package io.drareg.handlers

import io.drareg.events.Event
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler


class TCPServerHandler() : SimpleChannelInboundHandler<ByteBuf>() {

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: ByteBuf?) {
        println("packet incoming: $msg")
        val bytes = ByteArray(msg!!.readableBytes())
        msg.duplicate().readBytes(bytes)
        val event: Event = EventHandler.getEvent(msg)
        event.processEvent()
    }

}