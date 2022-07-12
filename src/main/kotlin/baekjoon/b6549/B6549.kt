package baekjoon.b6549

import java.util.*

/*
플랫폼 : 백준
문제번호 : 6549
문제제목 : 히스토그램에서 가장 큰 직사각형
난이도 : 플래티넘 5
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 세그먼트 트리, 분할 정복, 스택

알고리즘 설명
1. 스택의 top이 가리키는 막대 높이보다 현재 막대 높이가 작은 경우, 현재 막대의 높이보다 크거나 같은 원소는 모두 삭제한다.
2. 넓이는 요소를 삭제하면서 갱신해준다.

채점 결과 : 504ms/61296KB
풀이 날짜 : 2022/07/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    while (true) {
        val input = StringTokenizer(br.readLine())
        val n = input.nextToken().toInt()

        if (n == 0) {
            break
        }

        val heights = IntArray(n) { input.nextToken().toInt() }
        val answer = solution(n, heights)

        bw.write("$answer")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun solution(n: Int, heights: IntArray): Long {
    val stack = mutableListOf<Int>()

    var ret = 0L

    for (i in 0 until n) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[i]) {
            val h = heights[stack.removeLast()].toLong()
            val width = if (stack.isEmpty()) i else i - 1 - stack.last()
            ret = maxOf(ret, h * width)
        }

        stack.add(i)
    }

    while (stack.isNotEmpty()) {
        val h = heights[stack.removeLast()].toLong()
        val width = if (stack.isEmpty()) n else n - 1 - stack.last()
        ret = maxOf(ret, h * width)
    }

    return ret
}