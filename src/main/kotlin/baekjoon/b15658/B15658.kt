package baekjoon.b15658

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15658
문제제목 : 연산자 끼워넣기 (2)
난이도 : 실버 2
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 브루트포스 알고리즘, 백트래킹

알고리즘 설명
백트래킹

채점 결과 : 104ms/14360KB
풀이 날짜 : 2022/04/22
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var nums: IntArray

private var maxRes = Int.MIN_VALUE
private var minRes = Int.MAX_VALUE

fun main() {
    n = br.readLine().toInt()
    nums = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }
    val plus: Int
    val minus: Int
    val mul: Int
    val div: Int
    with(StringTokenizer(br.readLine())) {
        plus = nextToken().toInt()
        minus = nextToken().toInt()
        mul = nextToken().toInt()
        div = nextToken().toInt()
    }

    dfs(1, plus, minus, mul, div, nums[0])

    bw.write("$maxRes\n$minRes")
    bw.close()
    br.close()
}

private fun dfs(depth: Int, plus: Int, minus: Int, mul: Int, div: Int, sum: Int) {
    if (depth == n) {
        maxRes = maxOf(maxRes, sum)
        minRes = minOf(minRes, sum)
        return
    }

    if (plus > 0) {
        dfs(depth + 1, plus - 1, minus, mul, div, sum + nums[depth])
    }

    if (minus > 0) {
        dfs(depth + 1, plus, minus - 1, mul, div, sum - nums[depth])
    }

    if (mul > 0) {
        dfs(depth + 1, plus, minus, mul - 1, div, sum * nums[depth])
    }

    if (div > 0) {
        dfs(depth + 1, plus, minus, mul, div - 1, sum / nums[depth])
    }
}