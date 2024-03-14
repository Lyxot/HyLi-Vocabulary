package xyz.hyli.vocabulary.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import xyz.hyli.vocabulary.proto.WordProto
import java.io.InputStream
import java.io.OutputStream

object WordListSerializer: Serializer<WordProto.WordList> {
    override val defaultValue: WordProto.WordList
        get() = WordProto.WordList.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): WordProto.WordList {
        try {
            return WordProto.WordList.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: WordProto.WordList, output: OutputStream) {
        t.writeTo(output)
    }

}