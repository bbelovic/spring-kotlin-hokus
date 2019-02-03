package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

class MorseCodeHandler {
    private val charToMorse = mapOf("A" to "._",
            "B" to "_...",
            "C" to "_._.",
            "D" to "_..",
            "E" to ".",
            "F" to ".._.",
            "G" to "__.",
            "H" to "....",
            "I" to "..",
            "J" to ".___",
            "K" to "_._",
            "L" to "._..",
            "M" to "__",
            "N" to "_.",
            "O" to "___",
            "P" to ".__.",
            "Q" to "__._",
            "R" to "._.",
            "S" to "...",
            "T" to "_",
            "U" to ".._",
            "V" to "..._",
            "W" to ".__",
            "X" to "_.._",
            "Y" to "_.__",
            "Z" to "__..",
            "1" to ".____",
            "2" to "..___",
            "3" to "...__",
            "4" to "...._",
            "5" to ".....",
            "6" to "_....",
            "7" to "__...",
            "8" to "___..",
            "9" to "____.",
            "0" to "_____"
    )

    private val morseToChar = invert(charToMorse)

    fun encrypt(req: ServerRequest): Mono<ServerResponse> {
        val mono = req.bodyToMono(EncryptionPayload::class.java)
                .map { encrypt(it.payload) }
                .map { EncryptionPayload(it) }
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(mono, EncryptionPayload::class.java)

    }

    fun encrypt(input: String): String {
        return input.asSequence().joinToString(separator = " ") {
            charToMorse.getOrDefault(it.toString(), "")
        }
    }

    fun decrypt(encrypted: String): CharSequence {
        return encrypted.splitToSequence(delimiters = *arrayOf(" "))
                .joinToString(separator = "") { morseToChar.getOrDefault(it, ' ').toString()}
    }

    private fun invert(map: Map<String, String>): Map<CharSequence, CharSequence> {
        return map.asSequence().associate { entry -> entry.value to entry.key }
    }
}