package programmers.level1

import kotlin.math.sqrt

// 정수 제곱근 판별

class P12934 {
    fun solution(n: Long): Long {
        val sqrt = sqrt(n.toDouble()).toLong()

        return if (sqrt * sqrt == n) (sqrt + 1) * (sqrt + 1) else -1
    }
}