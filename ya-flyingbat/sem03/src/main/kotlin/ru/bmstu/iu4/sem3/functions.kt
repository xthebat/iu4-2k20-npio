package ru.bmstu.iu4.sem3

import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile

object Starter {

    fun filterStartswith(args: List<String>, prefix: String): List<String> {
        val output = mutableListOf<String>()
        for (item in args) {
            if (item.startsWith(prefix)) {
                output.add(item)
            }
        }
        return output
    }

    fun filterEndswith(args: List<String>, suffix: String): List<String> {
        val output = mutableListOf<String>()
        for (item in args) {
            if (item.endsWith(suffix)) {
                output.add(item)
            }
        }
        return output
    }

    @JvmStatic
    fun main1(args: Array<String>) {
        println(args.toList())

        val c1 = filterStartswith(args.toList(), "1")
        val c2 = filterStartswith(args.toList(), "2")

        val c3 = args.filter { it.startsWith("3") }
        val c4 = args.filter { it.startsWith("1") }

//        filter(map(args, { it.toInt(16) }, { it > 10 })

        val func = { it: Int -> it < 20 }

        val c5 = args
            .filter { it.all { ch -> ch in "0123456789ABCDEF" } }
            .map { it.toInt(16) }
            .filter { it < 40 }


        val e10 = c5.find { it == 8 } ?: 10  // value or null
        val e20 = c5.first { it == 16 }  // value or throw
        val e30 = c5.single { it == 32 }  // value only if single or throw

        val x: Int = e10

        c5.filter { it < 10 }.onEach { println(it) }.map { it }.forEach { println(it) }

        println(c1)
        println(c2)
        println(c3)
        println(c4)
        println(c5)

        println(e10)
        println(e20)
        println(e30)
    }

    data class Person(
        val _id: String,
        val index: Int,
        val tags: Any?
    )

    @JvmStatic
    fun main(args: Array<String>) {
//        val s = "temp/path.json".toFile().readText()

        val string = """[
            {
            "_id": "5f64da671f13ec426376cbb7",
            "index": 0,
            "tags": "fsdafas"
            }
            ]
        """.trimIndent()

        val json = string.parseJson<List<Person>>().forEach { println(it.tags) }

        // name gender age company balance
//       age > 20 < 30 -> sum balance
    }
}



