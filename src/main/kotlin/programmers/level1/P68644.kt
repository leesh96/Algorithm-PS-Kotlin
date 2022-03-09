package programmers.level1

import java.util.SortedSet

class P68644 {
    fun solution(numbers: IntArray) =
        sortedSetOf<Int>().apply {
            comb(numbers, this)
        }.toIntArray()

    private fun comb(arr: IntArray, saveIn: SortedSet<Int>, depth: Int = 0, index: Int = 0, sum: Int = 0) {
        if (depth == 2) {
            saveIn.add(sum)
            return
        }

        for (i in index..arr.lastIndex) {
            comb(arr, saveIn, depth + 1, i + 1, sum + arr[i])
        }
    }
}