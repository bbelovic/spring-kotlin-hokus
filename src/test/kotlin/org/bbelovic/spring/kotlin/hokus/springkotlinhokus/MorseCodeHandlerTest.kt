package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.junit.Assert
import org.junit.Test

class MorseCodeHandlerTest {
    @Test
    fun `should encode input text to Morse code`() {
        val input = "ABA"
        val actual = MorseCodeHandler().encrypt(input)
        Assert.assertEquals("._ _... ._", actual)
    }
}