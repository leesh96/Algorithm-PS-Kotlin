package baekjoon.b11505

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11505
문제제목 : 구간 곱 구하기
난이도 : 골드 1
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 세그먼트 트리

알고리즘 설명
세그먼트 트리의 구간 곱 버전

채점 결과 : 512ms/116316KB
풀이 날짜 : 2022/04/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
    }

    val arr = LongArray(n + 1)
    for (i in 1..n) {
        arr[i] = br.readLine().toLong()
    }

    val segTree = MulSeg(n)
    segTree.init(arr)

    repeat(m + k) {
        val input = StringTokenizer(br.readLine())
        val a = input.nextToken().toInt()
        val b = input.nextToken().toInt()
        val c = input.nextToken().toInt()

        if (a == 1) {
            arr[b] = c.toLong()
            segTree.update(idx = b, value = c.toLong())
        } else {
            bw.write("${segTree.multiple(left = b, right = c)}")
            bw.newLine()
        }
    }

    bw.close()
    br.close()
}

class MulSeg(private val n: Int) {
    private val segTree = LongArray(n * 4)

    companion object {
        private const val MOD = 1_000_000_007
    }

    fun init(arr: LongArray, start: Int = 1, end: Int = n, node: Int = 1): Long {
        if (start == end) {
            segTree[node] = arr[start]
            return segTree[node]
        }

        val mid = (start + end) / 2

        segTree[node] = (init(arr, start, mid, node * 2) * init(arr, mid + 1, end, node * 2 + 1)) % MOD
        return segTree[node]
    }

    fun multiple(left: Int, right: Int, start: Int = 1, end: Int = n, node: Int = 1): Long {
        if (left > end || right < start) {
            return 1L
        }

        if (left <= start && end <= right) {
            return segTree[node]
        }

        val mid = (start + end) / 2
        return (multiple(left, right, start, mid, node * 2) * multiple(left, right, mid + 1, end, node * 2 + 1)) % MOD
    }

    fun update(start: Int = 1, end: Int = n, node: Int = 1, idx: Int, value: Long): Long {
        if (idx < start || idx > end) {
            return segTree[node]
        }

        if (start == end) {
            segTree[node] = value
            return segTree[node]
        }

        val mid = (start + end) / 2

        segTree[node] = (update(start, mid, node * 2, idx, value) * update(mid + 1, end, node * 2 + 1, idx, value)) % MOD
        return segTree[node]
    }
}