package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class MorseCodeHandlerTest(private var input: String, private var expected: String) {

    @Test
    fun `should encode input text to Morse code`() {
        val actual = MorseCodeHandler().encrypt(input)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic @Parameters
        fun testData() = listOf(
                arrayOf("ABA", "._ _... ._"),
                arrayOf("A", "._"),
                arrayOf("123", ".____ ..___ ...__")
        )
    }
}