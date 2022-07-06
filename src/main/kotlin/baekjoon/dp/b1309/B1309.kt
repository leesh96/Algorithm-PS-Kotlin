package baekjoon.dp.b1309

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1309
문제제목 : 동물원
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 다이나믹 프로그래밍

알고리즘 설명
1. dp[i][0] : i번째에 배치하지 않았을 때의 경우의수 -> i-1번째의 모든 배치의 경우의수의 합
2. dp[i][1] : i번째에 왼쪽에 배치했을 때의 경우의수 -> i-1번째에 아무대도 배치하지 않았거나, 오른쪽에 배치했을 때 가능
3. dp[i][2] : i번째에 오른쪽에 배치했을 때의 경우의수 -> i-1번째에 아무대도 배치하지 않았거나, 왼쪽에 배치했을 때 가능

채점 결과 : 144ms/21984KB
풀이 날짜 : 2022/07/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MOD = 9901

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { IntArray(3) }

    Arrays.fill(dp[1], 1)

    for (i in 2..n) {
        dp[i][0] = dp[i-1].sum() % MOD
        dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD
        dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD
    }

    bw.write("${dp[n].sum() % MOD}")
    bw.close()
    br.close()
}