package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.fu.kofu.web.server
import org.springframework.fu.kofu.webApplication

val app = webApplication {
    beans {
        bean<EncryptionHandler>()
    }
    server {
        router {
            val handler = ref<EncryptionHandler>()
            GET("/") { req -> handler.encrypt(req) }
        }
        codecs {
            jackson()
        }
    }


}

fun main() {
    app.run()
}