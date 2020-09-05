// automatically generated by the FlatBuffers compiler, do not modify

package com.ht117.flatbuffer.model

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class People : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : People {
        __init(_i, _bb)
        return this
    }
    val id : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val idAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun idInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val name : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val nameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun nameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val yearOld : UInt
        get() {
            val o = __offset(8)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val address : com.ht117.flatbuffer.model.Address? get() = address(com.ht117.flatbuffer.model.Address())
    fun address(obj: com.ht117.flatbuffer.model.Address) : com.ht117.flatbuffer.model.Address? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val contact : com.ht117.flatbuffer.model.Contact? get() = contact(com.ht117.flatbuffer.model.Contact())
    fun contact(obj: com.ht117.flatbuffer.model.Contact) : com.ht117.flatbuffer.model.Contact? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun relatives(j: Int) : com.ht117.flatbuffer.model.People? = relatives(com.ht117.flatbuffer.model.People(), j)
    fun relatives(obj: com.ht117.flatbuffer.model.People, j: Int) : com.ht117.flatbuffer.model.People? {
        val o = __offset(14)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val relativesLength : Int
        get() {
            val o = __offset(14); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
        fun getRootAsPeople(_bb: ByteBuffer): People = getRootAsPeople(_bb, People())
        fun getRootAsPeople(_bb: ByteBuffer, obj: People): People {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createPeople(builder: FlatBufferBuilder, idOffset: Int, nameOffset: Int, yearOld: UInt, addressOffset: Int, contactOffset: Int, relativesOffset: Int) : Int {
            builder.startTable(6)
            addRelatives(builder, relativesOffset)
            addContact(builder, contactOffset)
            addAddress(builder, addressOffset)
            addYearOld(builder, yearOld)
            addName(builder, nameOffset)
            addId(builder, idOffset)
            return endPeople(builder)
        }
        fun startPeople(builder: FlatBufferBuilder) = builder.startTable(6)
        fun addId(builder: FlatBufferBuilder, id: Int) = builder.addOffset(0, id, 0)
        fun addName(builder: FlatBufferBuilder, name: Int) = builder.addOffset(1, name, 0)
        fun addYearOld(builder: FlatBufferBuilder, yearOld: UInt) = builder.addInt(2, yearOld.toInt(), 0)
        fun addAddress(builder: FlatBufferBuilder, address: Int) = builder.addOffset(3, address, 0)
        fun addContact(builder: FlatBufferBuilder, contact: Int) = builder.addOffset(4, contact, 0)
        fun addRelatives(builder: FlatBufferBuilder, relatives: Int) = builder.addOffset(5, relatives, 0)
        fun createRelativesVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startRelativesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endPeople(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
        fun finishPeopleBuffer(builder: FlatBufferBuilder, offset: Int) = builder.finish(offset)
        fun finishSizePrefixedPeopleBuffer(builder: FlatBufferBuilder, offset: Int) = builder.finishSizePrefixed(offset)
    }
}
