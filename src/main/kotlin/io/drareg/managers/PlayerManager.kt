package io.drareg.managers

import io.drareg.models.Player
import java.util.concurrent.ConcurrentHashMap

object PlayerManager : Manager {

    private val players: ConcurrentHashMap<Int, Player> = ConcurrentHashMap()

    fun playerLogin(playerId: Int){
        if(players.contains(playerId)){
            return
        }
        val player = Player()
        player.playerId = playerId
        player.lastLogin = System.currentTimeMillis()
        players[playerId] = player
    }

    fun getPlayerCount(): Int {
        return players.count()
    }

}