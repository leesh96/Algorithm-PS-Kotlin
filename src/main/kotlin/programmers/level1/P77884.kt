package programmers.level1

// 약수의 개수와 덧셈

class P77884 {
    companion object {
        private const val MAX = 1000
    }

    private val divisor = IntArray(MAX + 1) { 2 }.apply {
        this[1] = 1
        for (i in 2..MAX) {
            for (j in i*2..MAX step i) {
                this[j]++
            }
        }
    }

//    fun solution(left: Int, right: Int) =
//        divisor.slice(left..right).mapIndexed { index, i ->
//            if (i % 2 == 0) index + left else -(index + left)
//        }.sum()

    fun solution(left: Int, right: Int) =
        (left..right).sumOf { num ->
            if ((1..num).count { num % it == 0 } % 2 == 0) num else -num
        }
}