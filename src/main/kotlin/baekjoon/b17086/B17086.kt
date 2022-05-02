package baekjoon.b17086

import java.util.*

/*
플랫폼 : 백준
문제번호 : 17086
문제제목 : 아기 상어 2
난이도 : 실버 2
제한사항 : 2초/512MB
알고리즘 분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, BFS

알고리즘 설명
BFS
이미 안전 거리가 갱신되었다면 최소임을 보장하므로 그 칸은 갱신하지 않는다.

채점 결과 : 124ms/13724KB
풀이 날짜 : 2022/05/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val queue = LinkedList<Pair<Int, Int>>()
    val dist = Array(n) { IntArray(m) }
    val space = Array(n) { r ->
        StringTokenizer(br.readLine()).run {
            IntArray(m) { c ->
                nextToken().toInt().also { if (it == 1) queue.offer(r to c) }
            }
        }
    }

    var answer = Int.MIN_VALUE
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        repeat(8) {
            val nr = cur.first + dr[it]
            val nc = cur.second + dc[it]

            if (nr in 0 until n && nc in 0 until m && dist[nr][nc] == 0 && space[nr][nc] != 1) {
                dist[nr][nc] = dist[cur.first][cur.second] + 1
                answer = maxOf(answer, dist[nr][nc])
                queue.offer(nr to nc)
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}