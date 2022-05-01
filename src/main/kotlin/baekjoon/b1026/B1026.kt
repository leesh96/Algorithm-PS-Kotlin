package baekjoon.b1026

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1026
문제제목 : 보물
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 그리디, 정렬

알고리즘 설명
a의 가장 큰값이 b의 가장 작은 값에 매칭되고 a의 가장 작은 값은 b의 가장 큰 값에 매칭되기 때문에
a는 오름차순 정렬, b는 내림차순 정렬 후 연산을 수행한다.

채점 결과 : 144ms/19488KB
풀이 날짜 : 2022/05/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val a = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    val b = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    a.sort()
    b.sortDescending()

    val answer = a.zip(b) { n1, n2 -> n1 * n2 }.sum()
    bw.write("$answer")
    bw.close()
    br.close()
}