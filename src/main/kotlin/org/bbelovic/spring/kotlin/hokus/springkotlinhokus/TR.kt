package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}
