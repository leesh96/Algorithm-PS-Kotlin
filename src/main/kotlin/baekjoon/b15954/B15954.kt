package baekjoon.b15954

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 15954
문제제목 : 인형들
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 수학, 브루트포스 알고리즘

알고리즘 설명
수학 공식으로 평균과 표준편차를 구함
구하는 범위는 k만 살피는 것이 아니라 k부터 n까지 선택하는 경우를 모두 봐야한다

채점 결과 : 192ms/13092KB
풀이 날짜 : 2022/06/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    val likes = StringTokenizer(br.readLine()).run {
        IntArray(n) { nextToken().toInt() }
    }

    var answer = Double.MAX_VALUE
    for (ck in k..n) {
        for (i in 0..n - ck) {
            val avg = average(likes, i, ck)
            val standardDeviation = standardDeviation(likes, avg, i, ck)
            answer = minOf(answer, standardDeviation)
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun average(arr: IntArray, from: Int, t: Int): Double {
    var sum = 0.0
    for (i in 0 until t) {
        sum += arr[from + i]
    }
    return sum / t
}

private fun standardDeviation(arr: IntArray, avg: Double, from: Int, t: Int): Double {
    var sum = 0.0
    for (i in 0 until t) {
        sum += (arr[from + i] - avg).pow(2)
    }
    return sqrt(sum / t)
}