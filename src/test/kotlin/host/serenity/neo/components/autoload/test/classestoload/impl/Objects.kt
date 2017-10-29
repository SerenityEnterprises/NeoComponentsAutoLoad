package host.serenity.neo.components.autoload.test.classestoload.impl

import host.serenity.neo.components.autoload.test.classestoload.ObjectToLoad

class One : ObjectToLoad {
    override fun getNumber(): Int {
        return 1
    }
}

class Two : ObjectToLoad {
    override fun getNumber(): Int {
        return 2
    }
}

class Three : ObjectToLoad {
    override fun getNumber(): Int {
        return 3
    }
}
