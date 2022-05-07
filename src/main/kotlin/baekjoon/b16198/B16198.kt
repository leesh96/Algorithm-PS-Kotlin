package baekjoon.b16198

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16198
문제제목 : 에너지 모으기
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
백트래킹

채점 결과 : 156ms/16564KB
풀이 날짜 : 2022/05/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var answer = 0

fun main() {
    val n = br.readLine().toInt()
    val energy = mutableListOf<Int>()
    with(StringTokenizer(br.readLine())) {
        repeat(n) {
            energy.add(nextToken().toInt())
        }
    }

    dfs(0, energy)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(sum: Int, energy: MutableList<Int>) {
    if (energy.size <= 2) {
        answer = maxOf(answer, sum)
        return
    }

    for (i in 1 until energy.size - 1) {
        val temp = energy[i - 1] * energy[i + 1]
        val remove = energy[i]
        energy.removeAt(i)
        dfs(sum + temp, energy)
        energy.add(i, remove)
    }
}