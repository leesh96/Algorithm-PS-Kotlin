package programmers.level1

// 제일 작은 수 제거하기

class P12935 {
    fun solution(arr: IntArray): IntArray {
        return if (arr.size == 1) intArrayOf(-1)
        else arr.filter { num -> num != arr.minOf { it } }.toIntArray()
    }
}