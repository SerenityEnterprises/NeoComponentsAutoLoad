package host.serenity.neo.components.autoload.test

import host.serenity.neo.components.autoload.load
import host.serenity.neo.components.autoload.test.classestoload.ObjectToLoad
import host.serenity.neo.components.autoload.test.classestoload.ObjectsToLoadAutoLoadDescriptor
import org.junit.Assert.assertEquals
import org.junit.Test

class AutoLoadTest {
    @Test
    fun test() {
        var sum = 0

        load(ObjectsToLoadAutoLoadDescriptor(), { objectToLoadClass ->
            val objectToLoad: ObjectToLoad = objectToLoadClass.newInstance()
            sum += objectToLoad.getNumber()
        })

        assertEquals(6, sum)
    }
}