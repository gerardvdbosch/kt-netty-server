package io.drareg

import io.drareg.models.Player
import io.netty.buffer.Unpooled
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress


internal class NettyTCPServerTest {

    @BeforeEach
    internal fun setUp() {
        val server = NettyTCPServer(8080)
        server.run()
    }

    @org.junit.jupiter.api.Test
    fun packet() {
        val player = Player()
        player.playerId = 1
        val out = ByteArrayOutputStream()
        val os = ObjectOutputStream(out)
        os.writeObject(player)
        val packet = DatagramPacket(out.toByteArray(), out.size(), InetAddress.getLocalHost(), 8080)
        val socket = DatagramSocket()
        socket.send(packet)
        assert(true)
    }
}