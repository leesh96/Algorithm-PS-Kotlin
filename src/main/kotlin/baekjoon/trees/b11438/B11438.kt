package baekjoon.trees.b11438

import java.util.*
import kotlin.math.floor
import kotlin.math.log2

/*
플랫폼 : 백준
문제번호 : 11438
문제제목 : LCA 2
난이도 : 플래티넘 5
제한사항 : 1.5초(Kotlin 2.5초)/256MB
알고리즘 분류 : 자료 구조, 트리, 최소 공통 조상(LCA), 희소 배열

알고리즘 설명
1. 부모 노드의 정보를 2^k번째 부모로 저장하기
2. DP의 점화식: parents[cur][i] = parents[parents[cur][i-1]][i-1]
cur 노드의 2^i번째 부모는 cur 노드의 2^(i-1)번째 부모의 2^(i-1)번째 부모
트리의 최대 깊이는 log2(n)을 내림하고 정수로 변환해서 구함 -> 가능한 최대 조상의 레벨
3. 더 아래 있는 노드를 루트노드로 올라가면서 2^i번째 부모를 찾아간다. 언제까지? 깊이가 맞춰질 때까지
4. 깊이를 맞췄으면 2^i번째 부모로 올려가면서 최소 공통 조상을 찾음

*희소 배열로 풀 수 있음.

채점 결과 : 924ms/101772KB
풀이 날짜 : 2022/06/29
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val instance = B11438(n)
    instance.makeTree()
    instance.fillParents(1, 0, 1)
    val m = br.readLine().toInt()
    repeat(m) {
        val lca = with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            instance.lca(a, b)
        }

        bw.write("$lca")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private class B11438(private val n: Int) {
    val tree = Array(n + 1) { mutableListOf<Int>() }
    val maxDepth = floor(log2(n.toDouble())).toInt()
    val parents = Array(n + 1) { IntArray(maxDepth + 1) }
    val depths = IntArray(n + 1)

    fun makeTree() {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                tree[a].add(b)
                tree[b].add(a)
            }
        }
    }

    fun fillParents(cur: Int, parent: Int, level: Int) {
        parents[cur][0] = parent
        depths[cur] = level

        for (i in 1..maxDepth) {
            parents[cur][i] = parents[parents[cur][i-1]][i-1]
        }

        for (child in tree[cur]) {
            if (child != parent) {
                fillParents(child, cur, level + 1)
            }
        }
    }

    fun lca(a: Int, b: Int): Int {
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