package ru.bmstu.iu4.task03.table

data class Row(val cells:List<Cell>){

    constructor(vararg cells: Cell) : this(cells.toMutableList())

    constructor(vararg texts: String, width: Int, height: Int) : this(texts.map{ Cell(it, width,height) }.toMutableList())

    fun build(): String{
        val tmp = cells.map{it.build().split("\n")}
        val transpose = Array(tmp[0].size){ i -> Array(tmp.size) {j -> tmp[j][i] }   }
        val result = transpose.joinToString ("\n") {line -> line.joinToString("")}
        return result

    }

}