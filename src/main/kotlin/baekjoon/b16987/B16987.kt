package baekjoon.b16987

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16987
문제제목 : 계란으로 계란치기
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
백트래킹

채점 결과 : 172ms/13668KB
풀이 날짜 : 2022/05/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var eggs: Array<Egg>
private var answer = 0

fun main() {
    n = br.readLine().toInt()
    eggs = Array(n) { StringTokenizer(br.readLine()).run { Egg(nextToken().toInt(), nextToken().toInt()) } }
    backTracking(0, 0)
    bw.write("$answer")
    bw.close()
    br.close()
}

private class Egg(var durability: Int, val weight: Int)

private fun backTracking(index: Int, count: Int) {
    if (index == n) {
        answer = maxOf(answer, count)
        return
    }

    if (eggs[index].durability <= 0 || count == n - 1) {
        backTracking(index + 1, count)
        return
    }

    for (chk in 0 until n) {
        var nextCount = count
        if (chk == index) continue
        if (eggs[chk].durability <= 0) continue

        eggs[index].durability -= eggs[chk].weight
        eggs[chk].durability -= eggs[index].weight

        if (eggs[index].durability <= 0) nextCount++
        if (eggs[chk].durability <= 0) nextCount++

        backTracking(index + 1, nextCount)

        eggs[index].durability += eggs[chk].weight
        eggs[chk].durability += eggs[index].weight
    }
}