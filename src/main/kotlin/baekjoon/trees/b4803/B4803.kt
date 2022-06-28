package baekjoon.trees.b4803

import java.util.*

/*
플랫폼 : 백준
문제번호 : 4803
문제제목 : 트리
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 자료 구조, 그래프 탐색, 트리, DFS, 분리 집합

알고리즘 설명
1. dfs로 트리 판별
2. dfs를 수행하다가 이미 방문한 곳을 다시 방문하면 사이클
3. dfs 진입점의 횟수가 트리의 개수

채점 결과 : 456ms/62276KB
풀이 날짜 : 2022/06/28
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var case = 1

    while (true) {
        val input = StringTokenizer(br.readLine())
        val n = input.nextToken().toInt()
        val m = input.nextToken().toInt()

        if (n == 0 && m == 0) break

        val tree = Array(n) { mutableListOf<Int>() }
        repeat(m) {
            val edge = StringTokenizer(br.readLine())
            val a = edge.nextToken().toInt() - 1
            val b = edge.nextToken().toInt() - 1

            tree[a].add(b)
            tree[b].add(a)
        }

        val visit = BooleanArray(n)
        var count = 0
        for (i in 0 until n) {
            if (!visit[i]) {
                visit[i] = true
                if (dfs(tree, visit, i, -1)) count += 1
            }
        }

        when (count) {
            0 -> bw.write("Case $case: No trees.")
            1 -> bw.write("Case $case: There is one tree.")
            else -> bw.write("Case $case: A forest of $count trees.")
        }
        bw.newLine()
        case++
    }

    bw.close()
    br.close()
}

private fun dfs(tree: Array<MutableList<Int>>, visit: BooleanArray, cur: Int, parent: Int): Boolean {
    for (next in tree[cur]) {
        if (next == parent) continue
        if (visit[next]) return false
        visit[next] = true
        if (!dfs(tree, visit, next, cur)) return false
    }

    return true
}