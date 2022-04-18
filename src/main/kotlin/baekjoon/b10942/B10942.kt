package baekjoon.b10942

import java.util.*

/*
플랫폼 : 백준
문제번호 : 10942
문제제목 : 팰린드롬?
난이도 : 골드 3
제한사항 : 0.5초(코틀린 2.5초)/256MB
알고리즘 분류 : DP

알고리즘 설명
메모이제이션 사용
각 구간의 팰린드롬 여부를 전부 구한다.
구간의 간격이 1, 2일 때는 1번만 비교하면 된다.
구간의 간격이 3이상이면 S, E가 같으면 S + 1, E - 1이 팰린드롬인지 여부를 확인해야 한다. -> 여기서 dp 활용

채점 결과 : 808ms/215540KB
풀이 날짜 : 2022/04/18
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    val dp = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        dp[i][i] = true
    }

    for (i in 0 until n - 1) {
        if (arr[i] == arr[i + 1]) dp[i][i + 1] = true
    }

    for (i in 2 until n) {
        for (j in 0 until n - i) {
            if (arr[j] == arr[j + i] && dp[j+1][j+i-1]) dp[j][j+i] = true
        }
    }

    repeat(br.readLine().toInt()) {
        val st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt() - 1
        val e = st.nextToken().toInt() - 1

        bw.write(if (dp[s][e]) "1" else "0")
        bw.newLine()
    }

    bw.close()
    br.close()
}