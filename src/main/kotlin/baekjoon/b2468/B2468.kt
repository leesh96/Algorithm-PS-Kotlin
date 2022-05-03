package baekjoon.b2468

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2468
문제제목 : 안전 영역
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, BFS, DFS

알고리즘 설명
1. 모든 가능 높이에 대해 완전탐색
2. 영역의 수는 DFS의 진입점으로

채점 결과 : 252ms/18864KB
풀이 날짜 : 2022/05/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var map: Array<IntArray>
private lateinit var visit: Array<BooleanArray>

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

fun main() {
    n = br.readLine().toInt()
    var maxH = Int.MIN_VALUE
    map = Array(n) { StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt().also { maxH = maxOf(maxH, it) } } } }

    var answer = Int.MIN_VALUE
    for (h in 0..maxH) {
        visit = Array(n) { BooleanArray(n) }
        var count = 0

        for (r in 0 until n) {
            for (c in 0 until n) {
                if (!visit[r][c] && map[r][c] > h) {
                    count++
                    dfs(r, c, h)
                }
            }
        }

        answer = maxOf(answer, count)
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(r: Int, c: Int, h: Int) {
    visit[r][c] = true

    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        if (nr in 0 until n && nc in 0 until n && !visit[nr][nc] && map[nr][nc] > h) {
            dfs(nr, nc, h)
        }
    }
}