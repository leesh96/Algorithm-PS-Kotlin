package baekjoon.b2961

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 2961
문제제목 : 도영이가 만든 맛있는 음식
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
부분집합 구하기 - 재귀

채점 결과 : 88ms/12540KB
풀이 날짜 : 2022/05/09
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var flavor: Array<IntArray>
private lateinit var visit: BooleanArray
private var answer = 1_000_000_000

fun main() {
    n = br.readLine().toInt()
    flavor = Array(n) { StringTokenizer(br.readLine()).run { IntArray(2) { nextToken().toInt() } } }
    visit = BooleanArray(n)

    comb(0, 1, 0)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun comb(idx: Int, sour: Int, bitter: Int) {
    if (idx == n) {
        var selected = 0
        for (i in 0 until n) {
            if (visit[i]) selected++
        }
        if (selected != 0) {
            answer = minOf(answer, abs(sour - bitter))
        }
        return
    }

    visit[idx] = true
    comb(idx + 1, sour * flavor[idx][0], bitter + flavor[idx][1])
    visit[idx] = false
    comb(idx + 1, sour, bitter)
}