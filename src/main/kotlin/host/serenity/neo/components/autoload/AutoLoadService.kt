@file:JvmName("AutoLoadService")
package host.serenity.neo.components.autoload

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner
import java.util.function.Consumer

fun <T> load(descriptor: AutoLoadDescriptor<T>, consumer: (Class<T>) -> Unit) {
    val descriptorPackage = descriptor.javaClass.name.dropLast(descriptor.javaClass.simpleName.length + 1)
    val targetClass: Class<T> = descriptor.getTargetClass()

    val scanner = FastClasspathScanner(descriptorPackage).addClassLoader(targetClass.classLoader)

    val names =
            if (targetClass.isInterface)
                scanner.scan().getNamesOfClassesImplementing(targetClass)
            else
                scanner.scan().getNamesOfSubclassesOf(targetClass)

    for (name in names) {
        val potentialClass = targetClass.classLoader.loadClass(name)
        if (targetClass.isAssignableFrom(potentialClass) && targetClass != potentialClass) {
            @Suppress("UNCHECKED_CAST")
            consumer(potentialClass as Class<T>)
        }
    }
}

fun <T> load(descriptor: AutoLoadDescriptor<T>, consumer: Consumer<Class<T>>) {
    load(descriptor, { consumer.accept(it) })
}
