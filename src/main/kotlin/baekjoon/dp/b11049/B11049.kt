package baekjoon.dp.b11049

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11049
문제제목 : 행렬 곱셈 순서
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : 다이나믹 프로그래밍

알고리즘 설명
dp로 푸는 행렬 곱셈 순서

채점 결과 : 312ms/16632KB
풀이 날짜 : 2022/07/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val sizeOfMatrixes = Array(n) { StringTokenizer(br.readLine()).run { nextToken().toInt() to nextToken().toInt() } }

    val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    for (i in 0 until n) {
        dp[i][i] = 0
    }

    for (i in 1 until n) {
        for (j in 0 until n - i) {
            for (k in j until j + i) {
                val temp = dp[j][k] + dp[k + 1][j + i] + sizeOfMatrixes[j].first * sizeOfMatrixes[k].second * sizeOfMatrixes[j + i].second
                dp[j][j + i] = minOf(dp[j][j + i], temp)
            }
        }
    }

    bw.write("${dp[0][n - 1]}")
    bw.close()
    br.close()
}