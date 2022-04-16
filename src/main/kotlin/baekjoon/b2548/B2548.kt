package baekjoon.b2548

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 2548
문제제목 : 대표 자연수
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 브루트포스 알고리즘, 정렬

알고리즘 설명
1. 정렬하고 첫번째 ~ 마지막 값 사이의 모든 정수에 대해서
2. 차이의 합을 구해서 정답 갱신

채점 결과 : 592ms/20816KB
풀이 날짜 : 2022/04/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run {
        IntArray(n) { nextToken().toInt() }
    }
    arr.sort()

    var minSum = Int.MAX_VALUE
    var answer = 0
    for (i in arr.first()..arr.last()) {
        val sum = arr.sumOf { abs(it - i) }

        if (sum < minSum) {
            minSum = sum
            answer = i
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}