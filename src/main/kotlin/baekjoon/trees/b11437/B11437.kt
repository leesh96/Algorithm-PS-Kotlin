package baekjoon.trees.b11437

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11437
문제제목 : LCA
난이도 : 골드 3
제한사항 : 3초/256MB
알고리즘 분류 : 트리, 최소 공통 조상(LCA)

알고리즘 설명
1. LCA 선형 탐색 버전
2. 부모 노드 정보와 깊이 정보를 만들고
3. LCA를 선형으로 찾는다.
3 - 1. 두 노드의 깊이를 맞춘다. -> 부모로 타고가면됨
3 - 2. 이제 두 노드가 같아질 때까지 부모로 타고 간다.

채점 결과 :
풀이 날짜 : 2022/06/29
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val instance = B11437(n)
    instance.makeTree()
    instance.fillParents(1, 0, 1)
    val m = br.readLine().toInt()
    repeat(m) {
        val lca = StringTokenizer(br.readLine()).run {
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

class B11437(private val n: Int) {
    private val tree = Array(n + 1) { mutableListOf<Int>() }
    private val parents = IntArray(n + 1)
    private val depths = IntArray(n + 1)

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
        parents[cur] = parent
        depths[cur] = level

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

        while (depths[low] != depths[high]) {
            low = parents[low]
        }

        while (low != high) {
            low = parents[low]
            high = parents[high]
        }

        return low
    }
}