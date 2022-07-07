package baekjoon.b2589

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2589
문제제목 : 보물섬
난이도 : 골드 5
제한사항 : 1초/512MB
알고리즘 분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색

알고리즘 설명
1. bfs로 한 점에서 다른 점까지 최단 거리를 구해준다. 그 최단 거리들 중의 최대값을 선택
2. 1을 모든 점에 대해 수행하고 리턴 값들의 최대값을 구해주면 정답이다.

채점 결과 : 528ms/173916KB
풀이 날짜 : 2022/07/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var m = 0
private lateinit var map: Array<CharArray>
private lateinit var visit: Array<BooleanArray>

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

private var answer = Int.MIN_VALUE

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    map = Array(n) { br.readLine().toCharArray() }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'L') {
                visit = Array(n) { BooleanArray(m) }
                val ret = bfs(i, j)
                answer = maxOf(answer, ret)
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun bfs(r: Int, c: Int): Int {
    val queue = mutableListOf<State>()
    queue.add(State(r, c, 0))
    visit[r][c] = true

    var dist = 0
    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        repeat(4) {
            val nr = cur.r + dr[it]
            val nc = cur.c + dc[it]

            if (nr in 0 until n && nc in 0 until m && !visit[nr][nc] && map[nr][nc] == 'L') {
                queue.add(State(nr, nc, cur.dist + 1))
                dist = maxOf(dist, cur.dist + 1)
                visit[nr][nc] = true
            }
        }
    }

    return dist
}

data class State(
    val r: Int,
    val c: Int,
    val dist: Int
)