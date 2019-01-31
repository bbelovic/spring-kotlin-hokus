package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.junit.Assert
import org.junit.Test

class EncryptionHandlerTest {
    @Test
    fun `should encode input using Caesar cipher`() {
        val handler = EncryptionHandler()
        val actual = handler.encrypt("ABC")
        Assert.assertEquals("DEF", actual)
    }

    @Test
    fun test() {
        val c = 'A'
        println(c + 3)
        println('A'.toInt())
        println('Z'.toInt())
    }
}