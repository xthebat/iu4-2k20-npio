package ru.bmstu.iu4.task02

typealias Vector = ArrayList<Float>;
typealias VectorStr = Vector;
typealias VectorCol = Vector;

/* Vector-maker  */

fun vectorOf(v: String): Vector {
    val res: Vector = Vector()

    val num: List<String> = v.split(" ")
    for (i in num) res.add(i.toFloat())

    return res
}

/* Vector dot/cross funcs */

infix fun Vector.dot(B: Vector): Float {
    var cur: Float = 0F;
    for (k in this.indices)
        cur += this[k] * B[k]
    return cur;
}

/* Vector-column cross Matrix2D func */

infix fun VectorCol.crossmc(B: Matrix2D): VectorCol {
    require(this.size == B[0].size) { "Vector column len not equal matrix's strings count" }

    var res: VectorCol = VectorCol();
    var cur: Float = 0F;

    for (i in B[0].indices) { //strs
        cur = 0F;
        for (j in B.indices)  // cols
            cur += B[j][i] * this[i]
        res.add(cur);
    }

    return res;
}

/* Vector-string cross Matrix2D func */

infix fun VectorStr.crossms(B: Matrix2D): Matrix2D {
    require(this.size == B[0].size) { "Vector column len not equal matrix's strings count" }
    require(B.size == 1) { "Matrix should be vector-col" }

    var res: Matrix2D = matrixOf(listOf("0 0", "0 0"));

    for (i in this.indices) { //strs
        for (j in B[0].indices) //cols
            res[i][j] = B[0][j] * this[i]
    }

    return res;
}

/* Vector standart operators funcs */

operator fun Vector.plus(B: Vector): Vector {
    require(B.size == this.size) { "Vectors length different" }
    for (k in indices)
        this[k] += B[k];
    return this
}

operator fun Vector.plus(B: Float): Vector {
    for (k in indices)
        this[k] += B;
    return this
}

operator fun Vector.minus(B: Vector): Vector {
    require(B.size == this.size) { "Vectors length different" }
    for (k in indices)
        this[k] -= B[k];
    return this
}

operator fun Vector.minus(B: Float): Vector {
    for (k in indices)
        this[k] -= B;
    return this;
}

operator fun Vector.times(B: Vector): Vector {
    require(B.size == this.size) { "Vectors length different" }
    for (k in indices)
        this[k] *= B[k];
    return this;
}

operator fun Vector.times(B: Float): Vector {
    for (k in indices)
        this[k] *= B;
    return this;
}
