package baekjoon.b2210

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2210
문제제목 : 숫자판 점프
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, DFS

알고리즘 설명
DFS

채점 결과 : 264ms/35140KB
풀이 날짜 : 2022/04/21
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

private lateinit var board: Array<IntArray>
private lateinit var resultSet: MutableSet<String>

fun main() {
    board = Array(5) { with(StringTokenizer(br.readLine())) {
        IntArray(5) { nextToken().toInt() }
    } }
    resultSet = mutableSetOf()
    for (r in 0 until 5) {
        for (c in 0 until 5) {
            dfs(r, c, 0, IntArray(6))
        }
    }

    bw.write("${resultSet.size}")
    bw.close()
    br.close()
}

private fun dfs(r: Int, c: Int, depth: Int, arr: IntArray) {
    if (depth == 6) {
        resultSet.add(arr.joinToString(""))
        return
    }

    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        if (nr in 0 until 5 && nc in 0 until 5) {
            arr[depth] = board[nr][nc]
            dfs(nr, nc, depth + 1, arr)
        }
    }
}