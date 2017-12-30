package net.neverclear.emptyhand.network

import cpw.mods.fml.common.network.simpleimpl.IMessage
import io.netty.buffer.ByteBuf

class MessageEmptyHand : IMessage {

    var data: Byte = 0

    constructor() {}

    constructor(par1: Byte) {
        this.data = par1
    }

    override//IMessageのメソッド。ByteBufからデータを読み取る。
    fun fromBytes(buf: ByteBuf) {
        this.data = buf.readByte()
    }

    override//IMessageのメソッド。ByteBufにデータを書き込む。
    fun toBytes(buf: ByteBuf) {
        buf.writeByte(this.data.toInt())
    }
}