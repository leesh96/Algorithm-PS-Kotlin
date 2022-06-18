package baekjoon.strs.b1958

/*
플랫폼 : 백준
문제번호 : 1958
문제제목 : LCS 3
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : DP, 문자열

알고리즘 설명
LCS 알고리즘 -> 3차원 DP를 해도 시간초과 나지 않음

채점 결과 : 148ms/17840KB
풀이 날짜 : 2022/06/18
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine()
    val b = br.readLine()
    val c = br.readLine()

    val dp = Array(a.length + 1) { Array(b.length + 1) { IntArray(c.length + 1) } }

    for (i in 1..a.length) {
        for (j in 1..b.length) {
            for (k in 1..c.length) {
                if (a[i-1] == b[j-1] && b[j-1] == c[k-1]) {
                    dp[i][j][k] = dp[i-1][j-1][k-1] + 1
                } else {
                    dp[i][j][k] = maxOf(dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1])
                }
            }
        }
    }

    bw.write("${dp[a.length][b.length][c.length]}")
    bw.close()
    br.close()
}