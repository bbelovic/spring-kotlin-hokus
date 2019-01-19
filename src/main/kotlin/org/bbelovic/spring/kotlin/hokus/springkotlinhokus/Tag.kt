package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

open class Tag(private val name: String) {
    private val tags = mutableListOf<Tag>()

    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        tags.add(child)
    }

    override fun toString() =
            "<$name>${tags.joinToString("")}</$name>"

}

fun table(init: TABLE.() -> Unit) : Tag {
    val t = TABLE()
    t.init()
    return t
}