package baekjoon.b9613

import java.util.*

/*
플랫폼 : 백준
문제번호 : 9613
문제제목 : GCD 합
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 브루트포스 알고리즘, 정수론, 유클리드 호제법

알고리즘 설명
2개씩 고를 수 있는 모든 수 쌍의 gcd의 합을 구한다.
gcd는 유클리드 호제법 사용

채점 결과 : 88ms/12408KB
풀이 날짜 : 2022/05/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    repeat(t) {
        val input = StringTokenizer(br.readLine())
        val n = input.nextToken().toInt()
        val nums = IntArray(n) { input.nextToken().toInt() }

        var sum = 0L
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                sum += gcd(nums[i], nums[j])
            }
        }

        bw.write("$sum")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private tailrec fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}