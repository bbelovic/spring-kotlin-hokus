package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

class DependencyHandler {
    fun compile() {
        println("Added some dependency")
    }

    operator fun invoke(handler: DependencyHandler.() -> Unit) {
        handler()
    }
}