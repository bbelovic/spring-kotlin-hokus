package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import java.lang.StringBuilder

class MorseCodeHandler {
    private val codes = mapOf('A' to "._",
            'B' to "_..."
    )

    fun encrypt(input: String): String {
        return input.fold(StringBuilder("")) {sb: StringBuilder, ch: Char ->
            sb.append(codes[ch])
                    .append(" ")
        }.toString().trim()

    }
}