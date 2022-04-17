package baekjoon.b10971

import java.util.*

/*
플랫폼 : 백준
문제번호 : 10971
문제제목 : 외판원 순회 2
난이도 : 실버 2
제한사항 : 2초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹, 외판원 순회 문제

알고리즘 설명
DFS, 어디서 시작하던 최소 비용은 똑같다.

채점 결과 : 144ms/13244KB
풀이 날짜 : 2022/04/17
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var roads: Array<IntArray>
private lateinit var visit: BooleanArray
private var answer = Int.MAX_VALUE

fun main() {
    n = br.readLine().toInt()

    roads = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        for (j in 1..n) {
            roads[i][j] = st.nextToken().toInt()
        }
    }

    visit = BooleanArray(n + 1)
    visit[1] = true
    dfs(1, 1, 0, 1)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(start: Int, cur: Int, cost: Int, count: Int) {
    if (cur == start && cost > 0) {
        answer = minOf(answer, cost)
        return
    }

    for (next in 1..n) {
        if (roads[cur][next] > 0) {
            if (next == start && count == n) {
                dfs(start, next, cost + roads[cur][next], count + 1)
            } else if (!visit[next]) {
                visit[next] = true
                dfs(start, next, cost + roads[cur][next], count + 1)
                visit[next] = false
            }
        }
    }
}