package programmers.level1

import kotlin.math.sqrt

// 소수 만들기

class P12977 {
    companion object {
        private const val MAX = 3000
        private const val LIMIT = 3

        private val prime = BooleanArray(MAX + 1).apply {
            for (cur in 2..sqrt(MAX.toDouble()).toInt() + 1) {
                if (!this[cur]) {
                    for (mul in cur + cur..MAX step cur) {
                        this[mul] = true
                    }
                }
            }
        }
    }

    fun solution(nums: IntArray) =
        mutableListOf<Int>().apply { comb(nums, this) }
            .count { it >= 2 && !prime[it] }

    private fun comb(arr: IntArray, saveIn: MutableList<Int>, depth: Int = 0, index: Int = 0, sum: Int = 0) {
        if (depth == LIMIT) {
            saveIn.add(sum)
            return
        }

        for (i in index..arr.lastIndex) {
            comb(arr, saveIn, depth + 1, i + 1, sum + arr[i])
        }
    }
}