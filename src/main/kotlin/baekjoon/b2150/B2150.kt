package baekjoon.b2150

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2150
문제제목 : Strongly Connected Component
난이도 : 플래티넘 5
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 강한 연결 요소

알고리즘 설명
강(한)연결요소, 강(한)결합요소 구하기
방향 그래프의 모든 정점에서 다른 모든 정점으로 가는 경로가 존재하는 경우, 이 그래프를 강 결합 그래프라고 한다.
방향 그래프의 어떤 서브 그래프가 강 결합 그래프라면 이를 강 결합 컴포넌트라고 한다.
SCC는 정점 집합의 부분 집합 중 모든 정점간의 경로가 존재하는 정점들의 집합이다.

* 코사라주 알고리즘
1. 방문하지 않은 모든 정점으로부터 DFS를 수행한다. -> firstDFS 함수 구현 참고, dfs가 끝날 때 순서대로 정점을 표시한다.(= 그래프의 후위 순서)
2. 모든 간선의 방향이 반대인 전치 그래프(transpose graph)를 1의 DFS에서 가장 마지막에 표시한 정점부터 DFS를 수행한다.
3. 2의 DFS는 그래프의 가장 후위 정점부터 시작한다. 전치 그래프의 한 정점에서 나가는 간선은 원래 그래프에선 들어오는 간선이다.
4. 따라서 이 간선이 나가는 반대편 정점은 한 정점의 조상 또는 후손인데, 조상인 경우 이동하지 않고, 후손이라면 사이클을 찾은 것이다.
5. 여기서 찾은 사이클에 포함되는 모든 정점들이 하나의 SCC를 이룬다.

* 타잔 알고리즘
1. 모든 정점에 대해 DFS를 수행하여 SCC를 찾는 알고리즘이다. SCC가 성립하려면 부모로 돌아올 수 있어야 한다.
2. 정점마다 고유한 번호를 할당하고, DFS를 수행하면서 스택에 정점을 삽입한다.
3. 부모를 자기 자신으로 설정하고
4. 방문하지 않은 인접 정점에 대해서는 dfs를 계속 수행하고, 아직 DFS가 끝나지 않은 정점에 대해선 자식 노드의 부모 값을 통해서 계속 갱신한다.
5. 만약 부모가 그대로 자기 자신이라면, 스택에서 자기 자신의 정점 번호가 나올 때까지 모든 정점이 SCC이다.

채점 결과 : 700ms/62240KB(코사라주), 632ms/55540KB(타잔)
풀이 날짜 : 2022/07/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var v = 0
private var e = 0

private lateinit var graph: Array<MutableList<Int>>

// 코사라주 알고리즘
private lateinit var transposeGraph: Array<MutableList<Int>>
private lateinit var visit: BooleanArray
private lateinit var order: MutableList<Int>
private lateinit var parent: IntArray

// 타잔 알고리즘
private var id = 1
private lateinit var scc: MutableList<MutableList<Int>>
private lateinit var stack: MutableList<Int>
private lateinit var d: IntArray
private lateinit var finished: BooleanArray

fun main() {
    with(StringTokenizer(br.readLine())) {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }

    // 코사라주 알고리즘
    graph = Array(v) { mutableListOf() }
    transposeGraph = Array(v) { mutableListOf() }

    repeat(e) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1

            graph[a].add(b)
            transposeGraph[b].add(a)
        }
    }

    visit = BooleanArray(v)
    order = mutableListOf()
    parent = IntArray(v)

    for (i in 0 until v) {
        if (!visit[i]) {
            firstDFS(i)
        }
    }

    var n = 1
    while (order.isNotEmpty()) {
        if (visit[order.last()]) {
            secondDFS(order.last(), n)
            n += 1
        }
        order.removeLast()
    }

    val answer = parent.withIndex().groupBy({ it.value }, { it.index + 1 })

    bw.write("${answer.size}")
    bw.newLine()
    bw.write(answer.values.joinToString(separator = "\n") { it.joinToString(separator = " ", postfix = " -1") })

    // 타잔 알고리즘
    graph = Array(v) { mutableListOf() }

    repeat(e) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1

            graph[a].add(b)
        }
    }

    scc = mutableListOf()
    stack = mutableListOf()
    d = IntArray(v)
    finished = BooleanArray(v)

    for (i in 0 until v) {
        if (d[i] == 0) {
            tarjanSCC(i)
        }
    }

    bw.write("${scc.size}")
    bw.newLine()

    scc.sortBy { it.first() }
    bw.write(scc.joinToString(separator = "\n") { it.joinToString(separator = " ", postfix = " -1")})

    bw.close()
    br.close()
}

private fun firstDFS(v: Int) {
    visit[v] = true

    for (child in graph[v]) {
        if (!visit[child]) {
            firstDFS(child)
        }
    }

    order.add(v)
}

private fun secondDFS(v: Int, sccN: Int) {
    visit[v] = false
    parent[v] = sccN

    for (child in transposeGraph[v]) {
        if (visit[child]) {
            secondDFS(child, sccN)
        }
    }
}

private fun tarjanSCC(v: Int): Int {
    d[v] = id
    id += 1
    stack.add(v)

    var parent = d[v]
    for (child in graph[v]) {
        if (d[child] == 0) {
            parent = minOf(parent, tarjanSCC(child))
        } else if (!finished[child]) {
            parent = minOf(parent, d[child])
        }
    }

    if (parent == d[v]) {
        val component = mutableListOf<Int>()

        while (true) {
            val top = stack.removeLast()
            component.add(top + 1)
            finished[top] = true
            if (top == v) break
        }

        component.sort()
        scc.add(component)
    }

    return parent
}