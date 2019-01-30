package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

class EncryptionHandler {
    fun encrypt(req: ServerRequest): Mono<out ServerResponse> {
        val mono = req.bodyToMono(EncryptionPayload::class.java)
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(mono, EncryptionPayload::class.java)
    }

    private fun encrypt(input: String): String {
//        input.asSequence().mapTo()

        return ""
    }
}