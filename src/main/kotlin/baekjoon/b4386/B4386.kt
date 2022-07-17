package baekjoon.b4386

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 4386
문제제목 : 별자리 만들기
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 최소 신장 트리

알고리즘 설명
1. 별과 별 사이를 정점과 정점 사이의 비용 간선이라고 생각
2. 최소 신장 트리를 구한다.

채점 결과 : 152ms/14640KB
풀이 날짜 : 2022/07/17
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val stars = Array(n) { StringTokenizer(br.readLine()).run { nextToken().toDouble() to nextToken().toDouble() } }

    val pq = PriorityQueue<Triple<Int, Int, Double>>(compareBy { it.third })
    val parents = IntArray(n)

    for (i in 0 until n) {
        parents[i] = i
    }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val d = sqrt((stars[i].first - stars[j].first).pow(2) + (stars[i].second - stars[j].second).pow(2))
            pq.add(Triple(i, j, d))
        }
    }

    var answer = 0.0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (find(parents, cur.first) != find(parents, cur.second)) {
            union(parents, cur.first, cur.second)
            answer += cur.third
        }
    }

    bw.write(String.format("%.2f", answer))
    bw.close()
    br.close()
}

private fun find(parents: IntArray, x: Int): Int {
    if (x == parents[x]) {
        return x
    }

    parents[x] = find(parents, parents[x])
    return parents[x]
}

private fun union(parents: IntArray, a: Int, b: Int) {
    val ap = find(parents, a)
    val bp = find(parents, b)

    if (ap != bp) {
        parents[bp] = ap
    }
}