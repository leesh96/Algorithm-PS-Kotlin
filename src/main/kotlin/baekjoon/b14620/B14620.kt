package baekjoon.b14620

import java.util.*

/*
플랫폼 : 백준
문제번호 : 14620
문제제목 : 꽃길
난이도 : 실버 2
제한사항 : 2초/256MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. 씨앗 3개는 백트래킹
2. 조건 체크는 4방향에 대해 수행
3. 4방향에 꽃잎이 전개되니까 테두리는 확인 안해도 된다.

채점 결과 : 172ms/17284KB
풀이 날짜 : 2022/04/23
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

private var n = 0
private var answer = Int.MAX_VALUE

private lateinit var map: Array<IntArray>
private lateinit var visit: Array<BooleanArray>

fun main() {
    n = br.readLine().toInt()
    map = Array(n) { with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } } }
    visit = Array(n) { BooleanArray(n) }

    dfs(0, 0)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(count: Int, sum: Int) {
    if (count == 3) {
        answer = minOf(answer, sum)
        return
    }

    for (i in 1 until n - 1) {
        for (j in 1 until n - 1) {
            if (!visit[i][j] && checkFlower(i, j)) {
                markFlower(i, j, true)
                val cost = calcCost(i, j)
                dfs(count + 1, sum + cost)
                markFlower(i, j, false)
            }
        }
    }
}

private fun checkFlower(r: Int, c: Int): Boolean {
    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        if (visit[nr][nc]) return false
    }

    return true
}

private fun calcCost(r: Int, c: Int): Int {
    var cost = map[r][c]

    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        cost += map[nr][nc]
    }

    return cost
}

private fun markFlower(r: Int, c: Int, blooming: Boolean) {
    visit[r][c] = blooming

    repeat(4) {
        val nr = r + dr[it]
        val nc = c + dc[it]

        visit[nr][nc] = blooming
    }
}