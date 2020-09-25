package ru.bmstu.iu4

import kotlin.test.Test

fun countCache(json: Persons): Double {
    var summ = 0.0
    for (i in 0 until json.persons.size - 1) {
        if (json.persons[i].age > 20 && json.persons[i].age < 30)
        {
            var tmp = json.persons[i].balance
            if (tmp.contains("$")) {
                tmp = tmp.replace("$", "")
            }
            if (tmp.contains(",")) {
                tmp = tmp.replace(",", "")
            }
            summ = summ + tmp.toFloat()
        }
    }
    return summ
}