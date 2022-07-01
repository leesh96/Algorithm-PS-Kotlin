package baekjoon.trees.b1949

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1949
문제제목 : 우수 마을
난이도 : 골드 2
제한사항 : 2초/128MB
알고리즘 분류 : DP, 트리, 트리 DP

알고리즘 설명
1. 트리 DP는 DFS + DP가 기본
2-1. dp[i][0]: i 노드가 우수 마을이 아닌 경우 i를 루트로 하는 서브 트리의 주민 수의 최대값
2-2. dp[i][1]: i 노드가 우수 마을일 때 i를 루트로 하는 서브 트리의 주민 수의 최대값
3. 어떤 노드가 일반 마을이면 우수 마을이 반드시 인접 -> 부모 노드(현재 노드)가 우수 마을이면 자식 노드는 일반 마을, 부모 노드가 일반 마을이면 자식 노드는 우수 마을

채점 결과 : 212ms/21600KB
풀이 날짜 : 2022/07/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val populations = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    val tree = Array(n) { mutableListOf<Int>() }

    repeat(n - 1) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            tree[a].add(b)
            tree[b].add(a)
        }
    }

    val visit = BooleanArray(n)
    val dp = Array(n) { IntArray(2) }
    dfs(tree, populations, visit, 0, dp)

    var answer = 0
    for (i in 0 until n) {
        answer = maxOf(answer, maxOf(dp[i][0], dp[i][1]))
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(
    tree: Array<MutableList<Int>>,
    populations: IntArray,
    visit: BooleanArray,
    cur: Int,
    dp: Array<IntArray>
) {
    visit[cur] = true
    dp[cur][0] = 0
    dp[cur][1] = populations[cur]

    for (next in tree[cur]) {
        if (!visit[next]) {
            dfs(tree, populations, visit, next, dp)
            dp[cur][0] = dp[cur][0] + maxOf(dp[next][0], dp[next][1])
            dp[cur][1] = dp[cur][1] + dp[next][0]
        }
    }
}