package baekjoon.b1987

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1987
문제제목 : 알파벳
난이도 : 골드 4
제한사항 : 2초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹

알고리즘 설명
1. dfs와 백트래킹
2. 인접 정점을 방문하면서 해당 지역의 알파벳 사용 체크
3. 각 정점을 방문할 때 정답 갱신

채점 결과 : 1048ms/13832KB
풀이 날짜 : 2022/07/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var m = 0

private val dr = intArrayOf(1, -1, 0, 0)
private val dc = intArrayOf(0, 0, 1, -1)

private lateinit var board: Array<CharArray>
private lateinit var visit: Array<BooleanArray>
private lateinit var alpha: BooleanArray

private var answer = 0

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    board = Array(n) { br.readLine().toCharArray() }
    visit = Array(n) { BooleanArray(m) }
    alpha = BooleanArray(26)

    visit[0][0] = true
    alpha[board[0][0] - 'A'] = true
    dfs(0, 0, 1)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(r: Int, c: Int, count: Int) {
    answer = maxOf(answer, count)

    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        if (nr in 0 until n && nc in 0 until m && !visit[nr][nc] && !alpha[board[nr][nc] - 'A']) {
            visit[nr][nc] = true
            alpha[board[nr][nc] - 'A'] = true
            dfs(nr, nc, count + 1)
            visit[nr][nc] = false
            alpha[board[nr][nc] - 'A'] = false
        }
    }
}