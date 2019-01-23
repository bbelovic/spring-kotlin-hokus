package org.bbelovic.spring.kotlin.hokus.springkotlinhokus

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

class InMemoryHandler {
    private val dataMap = mutableMapOf<GoodKey,Array<Byte>>()

    fun storeData(rq: ServerRequest): Mono<ServerResponse> {
        dataMap[GoodKey(1)] = emptyArray()
        return Mono.empty<ServerResponse>()
    }
}

interface Key {
    fun getId(): Long
}

data class GoodKey(val id: Long)

data class LeakingKey(val id: Long)