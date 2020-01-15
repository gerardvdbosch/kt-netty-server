package io.drareg.handlers

import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.socket.DatagramPacket
import io.netty.util.CharsetUtil

class OutboundMessageHandler : SimpleChannelInboundHandler<DatagramPacket>() {
    override fun channelRead0(ctx: ChannelHandlerContext?, msg: DatagramPacket?) {
        println("Trying to send: $msg")
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        ctx?.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks!", CharsetUtil.UTF_8));
    }
}