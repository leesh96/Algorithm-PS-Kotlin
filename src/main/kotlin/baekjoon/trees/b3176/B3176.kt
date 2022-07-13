package baekjoon.trees.b3176

import java.util.*
import kotlin.math.floor
import kotlin.math.log2
import kotlin.math.pow

/*
플랫폼 : 백준
문제번호 : 3176
문제제목 : 도로 네트워크
난이도 : 플래티넘 4
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 트리, 최소 공통 조상, 희소 배열

알고리즘 설명
1. LCA 원리를 이용한다.
2. minDists[i][j]: i노드의 2^j번째 부모 노드까지의 도로 중 최소 도로 길이를 저장
3. maxDists[i][j]: i노드의 2^j번째 부모 노드까지의 도로 중 최대 도로 길이를 저장
4. 트리에서 두 노드 간의 경로: 1번 노드 -> 공통 조상 -> 2번 노드이다.
5. 따라서 공통 조상을 찾으면서 min, max도 갱신해주면 구할 수 있다.

채점 결과 : 1612ms/131728KB
풀이 날짜 : 2022/07/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var maxDepth = 0

private lateinit var roads: Array<MutableList<Road>>
private lateinit var parents: Array<IntArray>
private lateinit var depths: IntArray
private lateinit var minRoads: Array<IntArray>
private lateinit var maxRoads: Array<IntArray>

fun main() {
    n = br.readLine().toInt()
    maxDepth = floor(log2(n.toDouble())).toInt()
    roads = Array(n + 1) { mutableListOf() }
    parents = Array(n + 1) { IntArray(maxDepth + 1) }
    depths = IntArray(n + 1)
    minRoads = Array(n + 1) { IntArray(maxDepth + 1) }
    maxRoads = Array(n + 1) { IntArray(maxDepth + 1) }

    val hasParents = BooleanArray(n + 1)

    repeat(n - 1) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val w = nextToken().toInt()

            roads[a].add(Road(b, w))
            roads[b].add(Road(a, w))
            hasParents[b] = true
        }
    }

    var root = 1
    for (i in 1..n) {
        if (!hasParents[i]) {
            root = i
            break
        }
    }

    dfs(root, 0, 1)
    fillParents()

    val k = br.readLine().toInt()
    repeat(k) {
        val (min, max) = with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            lca(a, b)
        }
        bw.write("$min $max")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private class Road(val to: Int, val weight: Int)

private fun dfs(cur: Int, parent: Int, level: Int) {
    depths[cur] = level

    for (child in roads[cur]) {
        if (child.to != parent) {
            dfs(child.to, cur, level + 1)
            minRoads[child.to][0] = child.weight
            maxRoads[child.to][0] = child.weight
            parents[child.to][0] = cur
        }
    }
}

private fun fillParents() {
    for (i in 1..maxDepth) {
        for (j in 1..n) {
            parents[j][i] = parents[parents[j][i - 1]][i - 1]
            maxRoads[j][i] = maxOf(maxRoads[j][i - 1], maxRoads[parents[j][i - 1]][i - 1])
            minRoads[j][i] = minOf(minRoads[j][i - 1], minRoads[parents[j][i - 1]][i - 1])
        }
    }
}

private fun lca(a: Int, b: Int): Pair<Int, Int> {
    var low = a
    var high = b
    if (depths[low] < depths[high]) {
        high = low.also { low = high }
    }

    var min = Int.MAX_VALUE
    var max = -1

    for (i in maxDepth downTo 0) {
        if (2.toDouble().pow(i) <= depths[low] - depths[high]) {
            min = minOf(min, minRoads[low][i])
            max = maxOf(max, maxRoads[low][i])
            low = parents[low][i]
        }
    }

    if (low == high) return min to max

    for (i in maxDepth downTo 0) {
        if (parents[low][i] != parents[high][i]) {
            min = minOf(min, minRoads[low][i], minRoads[high][i])
            max = maxOf(max, maxRoads[low][i], maxRoads[high][i])
            low = parents[low][i]
            high = parents[high][i]
        }
    }

    min = minOf(min, minRoads[low][0], minRoads[high][0])
    max = maxOf(max, maxRoads[low][0], maxRoads[high][0])

    return min to max
}