package baekjoon.trees.b1761

import java.util.*
import kotlin.math.floor
import kotlin.math.log2

/*
플랫폼 : 백준
문제번호 : 1761
문제제목 : 정점들의 거리
난이도 : 플래티넘 5
제한사항 : 2초/128MB
알고리즘 분류 : 트리, 최소 공통 조상

알고리즘 설명
1. 루트노드부터 정점간의 거리를 구해놓는다.(LCA에서 부모노드 정보를 채우면서 구할 수 있음)
2. 두 정점간의 거리는 dist[a] + dist[b] - 2 * dist[lca]
3. LCA는 시간초과를 방지하기 위해 2^k씩 올라가는 LCA 사용

채점 결과 : 464ms/46740KB
풀이 날짜 : 2022/06/29
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val instance = B1761(n)
    instance.makeTree()
    instance.fillParents(1, 0, 1)
    val m = br.readLine().toInt()
    repeat(m) {
        val answer = with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            instance.getDist(a, b)
        }

        bw.write("$answer")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private class B1761(private val n: Int) {
    private class Node(val to: Int, val d: Int)
    private val tree = Array(n + 1) { mutableListOf<Node>() }
    private val maxDepth = floor(log2(n.toDouble())).toInt()
    private val parents = Array(n + 1) { IntArray(maxDepth + 1) }
    private val depths = IntArray(n + 1)
    private val dists = IntArray(n + 1)

    fun makeTree() {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val d = nextToken().toInt()
                tree[a].add(Node(b, d))
                tree[b].add(Node(a, d))
            }
        }
    }

    fun fillParents(cur: Int, parent: Int, level: Int) {
        depths[cur] = level
        parents[cur][0] = parent

        for (i in 1..maxDepth) {
            parents[cur][i] = parents[parents[cur][i-1]][i-1]
        }

        for (child in tree[cur]) {
            if (child.to != parent) {
                dists[child.to] = dists[cur] + child.d
                fillParents(child.to, cur, level + 1)
            }
        }
    }

    fun getDist(a: Int, b: Int): Int {
        val lca = lca(a, b)

        return dists[a] + dists[b] - (dists[lca] * 2)
    }

    private fun lca(a: Int, b: Int): Int {
        var low = a
        var high = b
        if (depths[low] < depths[high]) {
            high = low.also { low = high }
        }

        if (depths[low] != depths[high]) {
            for (i in maxDepth downTo 0) {
                if (depths[parents[low][i]] >= depths[high]) {
                    low = parents[low][i]
                }
            }
        }

        var ret = low
        if (low != high) {
            for (i in maxDepth downTo 0) {
                if (parents[low][i] != parents[high][i]) {
                    low = parents[low][i]
                    high = parents[high][i]
                }
                ret = parents[low][i]
            }
        }

        return ret
    }
}