package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class MorseCodeHandlerTest(private var plain: String, private var encrypted: String) {

    @Test
    fun `should encode plain text to Morse code`() {
        val actual = MorseCodeHandler().encrypt(plain)
        assertEquals(encrypted, actual)
    }

    @Test
    fun `should decode Morse code to plain text`() {
        val actual = MorseCodeHandler().decrypt(encrypted)
        assertEquals(plain, actual)
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