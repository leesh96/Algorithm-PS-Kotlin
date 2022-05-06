package baekjoon.b18429

import java.util.*

/*
플랫폼 : 백준
문제번호 : 18429
문제제목 : 근손실
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
1. 순열 구해서 조건 백트래킹

채점 결과 : 104ms/12900KB
풀이 날짜 : 2022/05/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var k = 0

private lateinit var info: IntArray
private lateinit var visit: BooleanArray

private var answer = 0

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    info = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    visit = BooleanArray(n)

    solution(0, 500)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun solution(depth: Int, sum: Int) {
    if (sum < 500) {
        return
    }

    if (depth == n) {
        answer++
        return
    }

    for (i in 0 until n) {
        if (!visit[i]) {
            visit[i] = true
            solution(depth + 1, sum + info[i] - k)
            visit[i] = false
        }
    }
}