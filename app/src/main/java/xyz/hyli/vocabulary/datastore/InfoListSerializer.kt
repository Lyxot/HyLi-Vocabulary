package xyz.hyli.vocabulary.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import xyz.hyli.vocabulary.proto.WordListProto
import java.io.InputStream
import java.io.OutputStream

object InfoListSerializer: Serializer<WordListProto.InfoList> {
    override val defaultValue: WordListProto.InfoList
        get() = WordListProto.InfoList.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): WordListProto.InfoList {
        try {
            return WordListProto.InfoList.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: WordListProto.InfoList, output: OutputStream) {
        t.writeTo(output)
    }
}