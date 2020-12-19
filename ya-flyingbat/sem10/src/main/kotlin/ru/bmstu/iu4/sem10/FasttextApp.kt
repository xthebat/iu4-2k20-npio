package ru.bmstu.iu4.sem10

import org.deeplearning4j.models.fasttext.FastText
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.ops.transforms.Transforms
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.splitBy
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.extensions.whitespaces
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object FasttextApp {
    val log = logger(FINEST)

    data class Record(val topic: String, val text: String)

    val DoubleArray.nd4j: INDArray get() = Nd4j.create(this)

    operator fun INDArray.set(i: Int, j: Int, value: Number): Unit = run { put(i, j, value) }

    operator fun INDArray.plus(other: INDArray): INDArray = add(other)

    operator fun INDArray.minus(other: INDArray): INDArray = sub(other)

    infix fun INDArray.pow(power: Int): INDArray = Transforms.pow(this, power)

    infix fun INDArray.dot(other: INDArray): Number = Transforms.dot(this, other).getNumber(0)

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "temp/input.json".toFile().readText().parseJson<List<Record>>()

        val dict = "temp/dict.txt".toFile().readLines().take(128).drop(1).map { it.split(" ").first() }

        val fasttext = FastText().apply { loadBinaryModel("temp/cc.ru.300.bin") }

        val words = listOf("кот", "кошка", "животное", "самолет", "танк", "человек")

        log.info { "dim = ${fasttext.dimension}" }

        val embeddingsWords = words.map {
            val vector = fasttext.getWordVector(it).nd4j
            vector / vector.norm2Number()
        }

        val resultWords = Nd4j.create(embeddingsWords.size, embeddingsWords.size)
        embeddingsWords.forEachIndexed { i, me ->
            embeddingsWords.forEachIndexed { j, other ->
                resultWords[i, j] = me dot other
            }
        }

        log.info { "\n$resultWords" }

        val embeddingsPhrases = input.mapIndexed { index, record ->
            val phrase = record.text
                .toCharArray()
                .filter { it.isLetterOrDigit() || it == ' ' }
                .joinToString("")
                .splitBy(whitespaces)
                .filter { it !in dict }

            var emb = Nd4j.zeros(fasttext.dimension)
            phrase.forEach { word -> emb += fasttext.getWordVector(word).nd4j }

            val result = emb

            log.config { "index = $index phrase = $phrase emb = $result " }

            result / result.norm2Number()
        }

        val resultPhrases = Nd4j.create(embeddingsPhrases.size, embeddingsPhrases.size)
        embeddingsPhrases.forEachIndexed { i, me ->
            embeddingsPhrases.forEachIndexed { j, other ->
                resultPhrases[i, j] = me dot other
            }
        }

        log.info { "\n$resultPhrases" }

//        val cat = fasttext.getWordVector("кот").nd4j
//        val shecat = fasttext.getWordVector("кошка").nd4j
//        val animal = fasttext.getWordVector("животное").nd4j
//        val plane = fasttext.getWordVector("животное").nd4j
//        val tank = fasttext.getWordVector("животное").nd4j
//
//        val dot = cat dot shecat
//
//        log.info { "dot = $dot" }
//
//        val normdot = cat / cat.norm2Number() dot shecat / shecat.norm2Number()
//
//        log.info { "normdot = $normdot" }
//
//        val dist = ((cat - shecat) pow 2).meanNumber()
//
//        log.info { "dist = $dist" }
    }
}