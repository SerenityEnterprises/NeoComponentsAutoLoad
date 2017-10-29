package host.serenity.neo.components.autoload

interface AutoLoadDescriptor<T> {
    fun getTargetClass(): Class<T>
}