package io.drareg.handlers

import io.drareg.events.ConnectEvent
import io.drareg.events.Event
import io.netty.buffer.ByteBuf

object EventHandler {

    fun getEvent(event: ByteBuf) : Event {
        return ConnectEvent()
    }

}