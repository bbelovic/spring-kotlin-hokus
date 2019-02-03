package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

class MorseCodeHandler {
    private val charToMorse = mapOf('A' to "._",
            'B' to "_...",
            'C' to "_._.",
            'D' to "_..",
            'E' to ".",
            'F' to ".._.",
            'G' to "__.",
            'H' to "....",
            'I' to "..",
            'J' to ".___",
            'K' to "_._",
            'L' to "._..",
            'M' to "__",
            'N' to "_.",
            'O' to "___",
            'P' to ".__.",
            'Q' to "__._",
            'R' to "._.",
            'S' to "...",
            'T' to "_",
            'U' to ".._",
            'V' to "..._",
            'W' to ".__",
            'X' to "_.._",
            'Y' to "_.__",
            'Z' to "__..",
            '1' to ".____",
            '2' to "..___",
            '3' to "...__",
            '4' to "...._",
            '5' to ".....",
            '6' to "_....",
            '7' to "__...",
            '8' to "___..",
            '9' to "____.",
            '0' to "_____"
    )

    private val morseToChar = invert(charToMorse)

    fun encrypt(input: String): String {
        return input.asSequence().joinToString(separator = " ") {
            charToMorse.getOrDefault(it, "")
        }
    }

    private fun invert(m: Map<Char, CharSequence>): Map<CharSequence, Char> {
        return m.asSequence().associate { entry -> entry.value to entry.key }
    }

    fun decrypt(encrypted: String): CharSequence {
        return encrypted.splitToSequence(delimiters = *arrayOf(" "))
                .joinToString(separator = "") { morseToChar.getOrDefault(it, ' ').toString()}
    }
}