package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.fu.kofu.web.server
import org.springframework.fu.kofu.webApplication

val app = webApplication {
    server {
        router {
            GET("/") { ok().syncBody("blabol") }
        }
    }

}

fun main() {
    app.run()
}