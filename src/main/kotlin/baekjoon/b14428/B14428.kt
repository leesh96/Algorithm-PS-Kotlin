package baekjoon.b14428

import java.util.*
import kotlin.math.ceil
import kotlin.math.log2

/*
플랫폼 : 백준
문제번호 : 14428
문제제목 : 수열과 쿼리 16
난이도 : 골드 1
제한사항 : 2초/512MB
알고리즘 분류 : 자료 구조, 세그먼트 트리

알고리즘 설명
1. 세그먼트 트리의 원리를 이용한다.
2. 해당 인덱스 구간에서 최솟값을 가진 요소의 인덱스를 저장

채점 결과 : 748ms/65036KB
풀이 날짜 : 2022/07/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = IntArray(n + 1)
    val input = StringTokenizer(br.readLine())
    for (i in 1..n) {
        arr[i] = input.nextToken().toInt()
    }

    val segN = 1 shl (ceil(log2(n.toDouble())).toInt() + 1)
    val segTree = IntArray(segN)

    segTree.init(arr, 1, n, 1)

    repeat(br.readLine().toInt()) {
        with(StringTokenizer(br.readLine())) {
            val t = nextToken().toInt()

            if (t == 1) {
                val idx = nextToken().toInt()
                val value = nextToken().toInt()
                segTree.update(arr, 1, n, 1, idx, value)
            } else if (t == 2) {
                val left = nextToken().toInt()
                val right = nextToken().toInt()
                bw.write("${segTree.query(arr, 1, n, left, right, 1)}")
                bw.newLine()
            }
        }
    }

    bw.close()
    br.close()
}

private fun IntArray.init(arr: IntArray, start: Int, end: Int, idx: Int) {
    if (start == end) {
        this[idx] = start
        return
    }

    val mid = (start + end) / 2
    init(arr, start, mid, idx * 2)
    init(arr, mid + 1, end, idx * 2 + 1)
    this[idx] = if (arr[this[idx * 2]] <= arr[this[idx * 2 + 1]]) this[idx * 2] else this[idx * 2 + 1]
}

private fun IntArray.update(arr: IntArray, start: Int, end: Int, idx: Int, target: Int, value: Int) {
    if (target < start || target > end) {
        return
    }

    if (start == end) {
        this[idx] = target
        arr[target] = value
        return
    }

    val mid = (start + end) / 2
    update(arr, start, mid, idx * 2, target, value)
    update(arr, mid + 1, end, idx * 2 + 1, target, value)
    this[idx] = if (arr[this[idx * 2]] <= arr[this[idx * 2 + 1]]) this[idx * 2] else this[idx * 2 + 1]
}

private fun IntArray.query(arr: IntArray, start: Int, end: Int, left: Int, right: Int, idx: Int): Int {
    if (left > end || right < start) {
        return -1
    }

    if (left <= start && end <= right) {
        return this[idx]
    }

    val mid = (start + end) / 2
    val leftMin = query(arr, start, mid, left, right, idx * 2)
    val rightMin = query(arr, mid + 1, end, left, right, idx * 2 + 1)

    return when {
        leftMin == -1 -> rightMin
        rightMin == -1 -> leftMin
        arr[leftMin] <= arr[rightMin] -> leftMin
        else -> rightMin
    }
}