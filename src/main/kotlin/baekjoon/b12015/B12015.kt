package baekjoon.b12015

import java.util.*

/*
플랫폼 : 백준
문제번호 : 12015
문제제목 : 가장 긴 증가하는 부분 수열 2
난이도 : 골드 2
제한사항 : 1초/512MB
알고리즘 분류 : 이분 탐색

알고리즘 설명
LIS - DP로 풀면 시간 초과나기 때문에 이분 탐색으로 푼다.

채점 결과 : 712ms/147772KB
풀이 날짜 : 2022/04/29
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>().apply { add(0) }
    val st = StringTokenizer(br.readLine())

    for (i in 0 until n) {
        val num = st.nextToken().toInt()

        if (num > list.last()) {
            list.add(num)
        } else {
            var start = 0
            var end = list.size - 1

            while (start < end) {
                val mid = (start + end) / 2

                if (num <= list[mid]) end = mid
                else start = mid + 1
            }

            list[end] = num
        }
    }

    bw.write("${list.size - 1}")
    bw.close()
    br.close()
}