package baekjoon.dp.b11055

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11055
문제제목 : 가장 큰 증가 부분 수열
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : 다이나믹 프로그래밍

알고리즘 설명
1. 가장 긴 증가하는 부분 수열을 응용
2. dp배열의 해당 인덱스 까지 증가하는 부분 수열의 가장 큰 합을 저장

채점 결과 : 120ms/12804KB
풀이 날짜 : 2022/07/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    val dp = IntArray(n)

    dp[0] = arr[0]
    var answer = dp[0]
    for (i in 1 until n) {
        dp[i] = arr[i]
        for (j in 0 until i) {
            if (arr[j] < arr[i]) {
                dp[i] = maxOf(dp[i], dp[j] + arr[i])
                answer = maxOf(answer, dp[i])
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}