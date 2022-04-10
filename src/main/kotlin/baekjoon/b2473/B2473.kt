package baekjoon.b2473

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 2473
문제제목 : 세 용액
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 정렬, 이분 탐색, 투 포인터

알고리즘 설명
1. 시작 위치를 고정해두고, 투 포인터 탐색

채점 결과 : 720ms/296072KB
풀이 날짜 : 2022/04/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val liquid = StringTokenizer(br.readLine()).run { LongArray(n) { nextToken().toLong() } }
    liquid.sort()

    var answer = Triple(1_000_000_001L, 1_000_000_001L, 1_000_000_001L)

    for (first in 0..n-3) {
        var second = first + 1
        var third = n - 1

        while (second < third) {
            val select = Triple(liquid[first], liquid[second], liquid[third])
            answer = minOf(answer, select, compareBy { abs(it.first + it.second + it.third) })

            val sum = select.first + select.second + select.third
            if (sum < 0) second++
            else third--
        }
    }

    bw.write("${answer.first} ${answer.second} ${answer.third}")
    bw.close()
    br.close()
}