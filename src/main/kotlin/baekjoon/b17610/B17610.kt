package baekjoon.b17610

import java.util.*

/*
플랫폼 : 백준
문제번호 : 17610
문제제목 : 양팔저울
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. 무게추를 사용하지 않았을 때와 해당 무게추를 어떻게 사용했는지(무게를 더하는데 썼는지, 모자란 무게에 썼는지)로 분기
2. 재귀를 통해 모든 조합을 탐색

채점 결과 : 164ms/20972KB
풀이 날짜 : 2022/07/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val k = br.readLine().toInt()
    val weights = StringTokenizer(br.readLine()).run { IntArray(k) { nextToken().toInt() } }
    val sum = weights.sum()
    val possible = BooleanArray(sum + 1)

    dfs(0, k, 0, weights, possible)

    var answer = 0
    for (i in 1..sum) {
        if (!possible[i]) {
            answer += 1
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(idx: Int, k: Int, weight: Int, weights: IntArray, possible: BooleanArray) {
    if (idx == k) {
        if (weight > 0) {
            possible[weight] = true
        }
        return
    }

    dfs(idx + 1, k, weight, weights, possible)
    dfs(idx + 1, k, weight + weights[idx], weights, possible)
    dfs(idx + 1, k, weight - weights[idx], weights, possible)
}