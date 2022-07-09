package baekjoon.b10817

import java.util.*

/*
플랫폼 : 백준
문제번호 : 10817
문제제목 : 세 수
난이도 : 브론즈 3
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. 세 수의 합에서 최댓값과 최솟값을 빼면 두 번째로 큰 수이다.

채점 결과 : 128ms/18380KB
풀이 날짜 : 2022/07/09
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val numbers = StringTokenizer(br.readLine()).run { IntArray(3) { nextToken().toInt() } }

    val answer = numbers.sum() - numbers.minOf { it } - numbers.maxOf { it }

    bw.write("$answer")
    bw.close()
    br.close()
}