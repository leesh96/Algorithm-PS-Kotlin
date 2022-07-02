package baekjoon.trees.b14267

import java.util.*

/*
플랫폼 : 백준
문제번호 : 14267
문제제목 : 회사 문화 1
난이도 : 골드 4
제한사항 : 2초/512MB
알고리즘 분류 : DP, 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색, 트리 DP

알고리즘 설명
1. 직속 상사가 칭찬을 하면 해당 상사를 루트로 하는 서브 트리 전부에 칭찬 누적
2. 직속 상사 입력 정보로 상사 - 부하 트리를 만든다.
3. 직속 상사로부터 칭찬 받은 정보가 주어지면 해당 직원이 칭찬 받은 수치를 배열에 입력
4. 트리를 dfs하면서 칭찬 수치를 누적시킨다.

채점 결과 : 620ms/89784KB
풀이 날짜 : 2022/07/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val nm = StringTokenizer(br.readLine())
    val n = nm.nextToken().toInt()
    val m = nm.nextToken().toInt()

    val tree = Array(n + 1) { mutableListOf<Int>() }
    val bossInput = StringTokenizer(br.readLine())
    for (i in 1..n) {
        val parent = bossInput.nextToken().toInt()
        if (parent != -1) {
            tree[parent].add(i)
        }
    }

    val praises = IntArray(n + 1)
    repeat(m) {
        val input = StringTokenizer(br.readLine())
        val i = input.nextToken().toInt()
        val w = input.nextToken().toInt()
        praises[i] += w
    }

    dfs(1, tree, praises)

    for (i in 1..n) {
        bw.write("${praises[i]} ")
    }

    bw.close()
    br.close()
}

private fun dfs(cur: Int, tree: Array<MutableList<Int>>, praises: IntArray) {
    for (child in tree[cur]) {
        praises[child] += praises[cur]
        dfs(child, tree, praises)
    }
}