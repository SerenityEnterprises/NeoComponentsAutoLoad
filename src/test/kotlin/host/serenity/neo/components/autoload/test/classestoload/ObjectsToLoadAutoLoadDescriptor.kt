package host.serenity.neo.components.autoload.test.classestoload

import host.serenity.neo.components.autoload.AutoLoadDescriptor

class ObjectsToLoadAutoLoadDescriptor : AutoLoadDescriptor<ObjectToLoad> {
    override fun getTargetClass(): Class<ObjectToLoad> {
        return ObjectToLoad::class.java
    }
}

interface ObjectToLoad {
    fun getNumber(): Int
}