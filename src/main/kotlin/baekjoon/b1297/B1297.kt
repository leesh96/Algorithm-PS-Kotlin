package baekjoon.b1297

import java.util.*
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 1297
문제제목 : TV 크기
난이도 : 브론즈 4
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 기하학, 피타고라스 정리

알고리즘 설명
피타고라스 정의에 의해 대각선 제곱 = 가로의 제곱 + 세로의 제곱
주어진 값은 비율이므로 식을 다시 쓰면
대각선 제곱 = (w의 비 * x)의 제곱 + (h * x)의 제곱
x는 대각선 제곱 / ((w의 비)의 제곱 + (h의 비)의 제곱 결과의 제곱근이다.

채점 결과 : 92ms/12308KB
풀이 날짜 : 2022/04/26
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val diag: Int
    val h: Int
    val w: Int
    with(StringTokenizer(br.readLine())) {
        diag = nextToken().toInt()
        h = nextToken().toInt()
        w = nextToken().toInt()
    }

    val ratio = sqrt(diag.toDouble().pow(2) / (h.toDouble().pow(2) + w.toDouble().pow(2)))
    bw.write("${floor(ratio * h).toInt()} ${floor(ratio * w).toInt()}")
    bw.close()
    br.close()
}