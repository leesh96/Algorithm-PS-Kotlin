package programmers.level1

// 로또의 최고 순위와 최저 순위

class P77484 {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return lottos.partition { it == 0 }.let { (zero, nonZero) ->
            val matchCount = nonZero.count() { winNums.contains(it) }
            intArrayOf(
                getRank(matchCount + zero.size),
                getRank(matchCount)
            )
        }
    }

    private fun getRank(count: Int): Int = when (count) {
        in 6..Int.MAX_VALUE -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }
}