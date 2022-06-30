package baekjoon.trees.b3584

import java.util.*
import kotlin.math.floor
import kotlin.math.log2

/*
플랫폼 : 백준
문제번호 : 3584
문제제목 : 가장 가까운 공통 조상
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, DFS, 최소 공통 조상(LCA)

알고리즘 설명
1. 간선 정보가 부모 - 자식 관계로 주어지고
2. 루트가 정해져있지 않기 때문에 루트를 찾아야한다. -> 부모 노드를 갖는 노드 체크
3. LCA 알고리즘

채점 결과 : 316ms/31920KB
풀이 날짜 : 2022/06/30
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val instance = B3584(n)
        instance.makeTree()
        val root = instance.getRoot()
        instance.fillParents(root, 0, 1)
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

class B3584(private val n: Int) {
    private val tree = Array(n + 1) { mutableListOf<Int>() }
    private val maxDepth = floor(log2(n.toDouble())).toInt()
    private val depths = IntArray(n + 1)
    private val parents = Array(n + 1) { IntArray(maxDepth + 1) }
    private val hasParent = BooleanArray(n + 1)

    fun makeTree() {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                tree[a].add(b)
                hasParent[b] = true
            }
        }
    }

    fun getRoot(): Int {
        for (i in 1..n) {
            if (!hasParent[i]) return i
        }

        return 0
    }

    fun fillParents(cur: Int, parent: Int, level: Int) {
        depths[cur] = level
        parents[cur][0] = parent

        for (i in 1..maxDepth) {
            parents[cur][i] = parents[parents[cur][i-1]][i-1]
        }

        for (child in tree[cur]) {
            fillParents(child, cur, level + 1)
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