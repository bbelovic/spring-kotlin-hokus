package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.fu.kofu.web.server
import org.springframework.fu.kofu.webApplication
import org.springframework.web.reactive.function.server.ServerRequest

val app = webApplication {
    beans {
        bean<EncryptionHandler>()
        bean<MorseCodeHandler>()
    }
    server {
        router {
            val handler = ref<EncryptionHandler>()
            GET("/") { req: ServerRequest -> handler.encrypt(req) }
            GET("/encrypt/morse") {req: ServerRequest -> ref<MorseCodeHandler>().encrypt(req)}
        }
        codecs {
            jackson()
        }
    }
}

fun main() {
    app.run()
}