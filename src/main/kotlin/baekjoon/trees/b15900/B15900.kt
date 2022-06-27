package baekjoon.trees.b15900

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15900
문제제목 : 나무 탈출
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 트리, 그래프 이론, 그래프 탐색, DFS

알고리즘 설명
1. 게임말은 부모-자식 간선을 움직인다.
2. 처음에는 게임말이 모두 리프 노드에 있다.
3. 루트 노드부터 리프 노드까지 DFS로 탐색하면서 트리의 모든 리프 노드의 깊이의 총합을 구한다.
4. 2명이 번갈아가면서 말을 움직이므로 깊이의 총합이 2로 나누어 떨어지면 패배

채점 결과 : 920ms/196308KB
풀이 날짜 : 2022/06/27
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var answer = 0

fun main() {
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val link = StringTokenizer(br.readLine())
        val a = link.nextToken().toInt()
        val b = link.nextToken().toInt()

        graph[a].add(b)
        graph[b].add(a)
    }
    val visit = BooleanArray(n + 1)
    dfs(1, 0, graph, visit)
    if (answer % 2 == 0) bw.write("No") else bw.write("Yes")
    bw.close()
    br.close()
}

private fun dfs(node: Int, depth: Int, graph: Array<MutableList<Int>>, visit: BooleanArray) {
    visit[node] = true

    for (next in graph[node]) {
        if (!visit[next]) {
            dfs(next, depth + 1, graph, visit)
        }
    }

    if (node != 1 && graph[node].size == 1) {
        answer += depth
    }
}