package io.drareg

import io.drareg.handlers.OutboundMessageHandler
import io.netty.bootstrap.Bootstrap
import io.netty.channel.*
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.DatagramChannel
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.channel.socket.nio.NioSocketChannel
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.UnknownHostException


class Client {

    val datagramChannel = createDatagramChannel(InetAddress.getLocalHost().hostAddress)

    fun write(obj: Any){
        this.datagramChannel?.writeAndFlush(obj)
    }

    @Throws(UnknownHostException::class, InterruptedException::class)
    fun createDatagramChannel(localhostName: String?): Channel? {
        val group = NioEventLoopGroup()
        val clientBootstrap = Bootstrap()
        clientBootstrap.group(group)
        clientBootstrap.channel(NioSocketChannel::class.java)
        clientBootstrap.remoteAddress(InetSocketAddress("localhost", 8080))
        try {
            clientBootstrap.handler(object : ChannelInitializer<SocketChannel>() {
                @Throws(Exception::class)
                override fun initChannel(socketChannel: SocketChannel) {
                    socketChannel.pipeline().addLast(OutboundMessageHandler())
                }
            })
            val channelFuture: ChannelFuture = clientBootstrap.connect().sync()
            return channelFuture.channel()
        } finally {
            group.shutdownGracefully().sync()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Client().write("hello world")
        }
    }

}