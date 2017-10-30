@file:JvmName("AutoLoadService")
package host.serenity.neo.components.autoload

import com.google.common.reflect.ClassPath

fun <T> load(descriptor: AutoLoadDescriptor<T>, consumer: (Class<T>) -> Unit) {
    val classpath = ClassPath.from(descriptor.javaClass.classLoader)
    val packageName = descriptor.javaClass.name.dropLast(descriptor.javaClass.simpleName.length + 1)

    try {
        classpath.getTopLevelClassesRecursive(packageName)
                .map { it.load() }
                .filter { descriptor.getTargetClass().isAssignableFrom(it) }
                .filter { it.constructors.isNotEmpty() }
                .forEach {
                    @Suppress("UNCHECKED_CAST")
                    consumer(it as Class<T>)
                }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
