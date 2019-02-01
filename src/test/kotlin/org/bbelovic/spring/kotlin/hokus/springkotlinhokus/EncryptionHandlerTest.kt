package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.junit.Assert.assertEquals
import org.junit.Test

class EncryptionHandlerTest {
    @Test
    fun `should encode input using Caesar cipher`() {
        val handler = EncryptionHandler()
        assertEquals("DEF", handler.encrypt("ABC"))
        assertEquals("CCC", handler.encrypt("ZZZ"))
        assertEquals("ABC", handler.encrypt("XYZ"))
    }

}