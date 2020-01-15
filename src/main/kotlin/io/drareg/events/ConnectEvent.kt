package io.drareg.events

import io.drareg.managers.Manager
import io.drareg.managers.PlayerManager
import io.drareg.models.Player

class ConnectEvent : Event {
    override val type: Int = 0x01
    override val timestamp: Long = System.currentTimeMillis()
    override val data: ByteArray = byteArrayOf()
    override val manager: Manager = PlayerManager

    override fun processEvent() {
        // loginHandler.playerLogin()
        val player: Player = Player()
    }

    override fun dataToObject() {

    }

}