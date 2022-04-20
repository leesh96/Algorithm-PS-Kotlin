package baekjoon.b10819

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 10819
문제제목 : 차이를 최대로
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
순열로 모든 경우의 수 탐색

채점 결과 : 116ms/13356KB
풀이 날짜 : 2022/04/20
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var nums: IntArray
private var answer = Int.MIN_VALUE

fun main() {
    n = br.readLine().toInt()
    nums = with(StringTokenizer(br.readLine())) {
        IntArray(n) { nextToken().toInt() }
    }

    perm(0, IntArray(n), BooleanArray(n))

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun perm(depth: Int, arr: IntArray, visit: BooleanArray) {
    if (depth == n) {
        var sum = 0
        for (i in 0 until n - 1) {
            sum += abs(arr[i] - arr[i+1])
        }
        answer = maxOf(answer, sum)
        return
    }

    for (i in 0 until n) {
        if (!visit[i]) {
            visit[i] = true
            arr[depth] = nums[i]
            perm(depth + 1, arr, visit)
            visit[i] = false
        }
    }
}