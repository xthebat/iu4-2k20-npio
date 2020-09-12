package ru.bmstu.iu4.task02

typealias Matrix = ArrayList<Vector>;
typealias Matrix2D = Matrix;

/* Matrix-maker */

fun matrixOf(mat: List<String>): Matrix{
    val res: Matrix = Matrix()

    for (it in mat){
        val nums: List<String> = it.split(" ")
        val mat_part: ArrayList<Float> = arrayListOf();
        for (num in nums){
            mat_part.add(num.toFloat());
        }
        res.add(mat_part)
    }
    return res

}

/* Matrix2D cross/dot funcs */

infix fun Matrix2D.cross(B: Matrix2D) : Matrix2D {
    require(this.size == B[0].size) {"Can't times unconsistent matrixes."}

    val res: Matrix2D = matrixOf(listOf("0 0", "0 0"));
    for (k in res.indices)   // cols
        for (v in res[k].indices){   // strs
            var cur: Float = 0F;
            for (i in this.indices){
                cur += this[i][v]*B[k][i]
            }
            res[k][v] = cur;
        }
    return res;
}


infix fun Matrix.dot(B: Matrix) : Matrix{
    for (k in this.indices)
        for (v in this[k].indices)
            this[k][v] *= B[k][v];
    return this
}

fun Matrix2D.transpose() : Matrix2D{
    var res: Matrix2D = matrixOf(listOf("0 0", "0 0"))
        for (i in this.indices)
            for (j in this.indices)
                res[j][i] = this[i][j];
    return res
}

/* Matrix2D standart operators funcs */

operator fun Matrix.plus(B: Matrix): Matrix{
    for (k in this.indices)
        for (v in B.indices)
            this[k][v] += B[k][v];
    return this
}

operator fun Matrix.plus(B: Float): Matrix{
    for (k in this.indices)
        for (v in this[k].indices)
            this[k][v] += B;
    return this
}

operator fun Matrix.minus(B: Matrix): Matrix{
    for (k in this.indices)
        for (v in B.indices)
            this[k][v] -= B[k][v];
    return this
}

operator fun Matrix.minus(B: Float): Matrix{
    for (k in this.indices)
        for (v in this[k].indices)
            this[k][v] -= B;
    return this
}

operator fun Matrix.times(B: Matrix): Matrix{
    for (k in this.indices)
        for (v in this[k].indices)
            this[k][v] *= B[k][v];
    return this
}

operator fun Matrix.times(B: Float): Matrix{
    for (k in this.indices)
        for (v in this[k].indices)
            this[k][v] *= B;
    return this;
}
