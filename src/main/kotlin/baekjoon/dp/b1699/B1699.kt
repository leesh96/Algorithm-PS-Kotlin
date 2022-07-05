package baekjoon.dp.b1699

import kotlin.math.floor
import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 1699
문제제목 : 제곱수의 합
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 다이나믹 프로그래밍

알고리즘 설명
1. 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다.
2. 1도 제곱수이다.
3. dp 배열을 만들고 각 요소를 최대로 설정 = 1의 합으로
4. dp[i] = 제곱수 항의 최소 갯수
5. i보다 작거나 같은 제곱수를 j라고 할 때, dp[i]는 dp[i - j] + 1 중의 최소값

채점 결과 : 156ms/13716KB
풀이 날짜 : 2022/07/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { it }

    for (i in 1..n) {
        val limit = floor(sqrt(i.toDouble())).toInt()
        for (j in 1..limit) {
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
        }
    }

    bw.write("${dp[n]}")
    bw.close()
    br.close()
}