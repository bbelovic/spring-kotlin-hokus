package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}