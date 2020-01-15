package io.drareg.events

import io.drareg.managers.Manager

interface Event {

    val type: Int
    val timestamp: Long
    val data: ByteArray
    val manager: Manager

    fun processEvent()

    fun dataToObject()
}