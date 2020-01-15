package io.drareg.events

enum class EventType(val byte: Byte) {
    NOT_DEFINED(0x00),
    LOGIN(0x01)
}