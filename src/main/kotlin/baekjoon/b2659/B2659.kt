package baekjoon.b2659

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2659
문제제목 : 십자카드 문제
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘, 정렬

알고리즘 설명
1. 모든 시계수를 구한다.
2. 입력의 시계수를 구한다.
3. 몇 번째 시계수인지 계산한다.

채점 결과 : 100ms/12804KB
풀이 날짜 : 2022/06/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = StringTokenizer(br.readLine()).run {
        getClockNum(nextToken().toInt(), nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
    }

    val clockNums = getAllClockNum()
    var answer = 0
    for (i in 1111..input) {
        if (clockNums[i]) answer++
    }
    bw.write("$answer")
    bw.close()
    br.close()
}

private fun getClockNum(a: Int, b: Int, c: Int, d: Int): Int {
    val v1 = a * 1000 + b * 100 + c * 10 + d
    val v2 = b * 1000 + c * 100 + d * 10 + a
    val v3 = c * 1000 + d * 100 + a * 10 + b
    val v4 = d * 1000 + a * 100 + b * 10 + c
    return minOf(v1, v2, v3, v4)
}

private fun getAllClockNum(): BooleanArray {
    val ret = BooleanArray(10000) { false }

    for (a in 1..9) {
        for (b in 1..9) {
            for (c in 1..9) {
                for (d in 1..9) {
                    ret[getClockNum(a, b, c, d)] = true
                }
            }
        }
    }

    return ret
}