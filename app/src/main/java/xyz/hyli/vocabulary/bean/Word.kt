package xyz.hyli.vocabulary.bean

data class WordList(
    val id: Int,
    var name: String,
    var words: MutableList<Word>,
    val timestamp: Long,
    var deleted: Boolean = false
)

data class Word(
    val id: Int,
    var word: String,
    var pronunciation: String,
    var meanings: MutableList<Meaning>,
    val timestamp: Long,
    var deleted: Boolean = false
)

data class Meaning(
    val id: Int,
    var partOfSpeech: String,
    var meaning: MutableList<String>,
    var deleted: Boolean = false
)

object PartOfSpeech {
    // 名词
    const val NOUN = "n."
    // 代词
    const val PRONOUN = "pron."
    // 动词
    const val VERB = "v."
    // 及物动词
    const val TRANSITIVE_VERB = "vt."
    // 不及物动词
    const val INTRANSITIVE_VERB = "vi."
    // 形容词
    const val ADJECTIVE = "adj."
    // 副词
    const val ADVERB = "adv."
    // 数词
    const val NUMERAL = "num."
    // 冠词
    const val ARTICLE = "art."
    // 介词
    const val PREPOSITION = "prep."
    // 连词
    const val CONJUNCTION = "conj."
    // 感叹词
    const val INTERJECTION = "int."
    // 缩略词
    const val ABBREVIATION = "abbr."
}