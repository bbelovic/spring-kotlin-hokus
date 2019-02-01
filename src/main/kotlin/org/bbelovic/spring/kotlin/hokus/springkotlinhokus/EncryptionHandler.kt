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

    fun encrypt(input: String): String {
        return input.fold(StringBuilder("")) {sb: StringBuilder, c: Char ->
            val enc = ((c.toInt() + 3 - 65) % 26) + 65
            sb.append((enc.toChar()))}
                .toString()
    }
}