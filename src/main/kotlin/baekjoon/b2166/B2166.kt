package baekjoon.b2166

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 2166
문제제목 : 다각형의 면적
난이도 : 골드 5
제한사항 : 2초/128MB
알고리즘 분류 : 기하학, 다각형의 넒이

알고리즘 설명
신발끈 공식 사용: 점의 좌표를 알 때 다각형의 넓이를 구하는 방법

채점 결과 : 172ms/17968KB
풀이 날짜 : 2022/04/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val x = IntArray(n + 1)
    val y = IntArray(n + 1)

    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            x[it] = nextToken().toInt()
            y[it] = nextToken().toInt()
        }
    }
    x[n] = x[0]
    y[n] = y[0]

    var sumOfRightDown = 0L
    var sumOfLeftDown = 0L
    for (i in 0 until n) {
        sumOfLeftDown += x[i].toLong() * y[i + 1].toLong()
        sumOfRightDown += x[i + 1].toLong() * y[i].toLong()
    }

    val answer = abs(sumOfLeftDown - sumOfRightDown) / 2.0
    bw.write(String.format("%.1f", answer))
    bw.close()
    br.close()
}