package baekjoon.b2502

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2502
문제제목 : 떡 먹는 호랑이
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 수학, DP, 브루트포스 알고리즘

알고리즘 설명
문제를 잘보면 피보나치 수열을 이루고있다.
첫째날의 떡을 x, 둘째날의 떡을 y라고 하면 셋째날은 x + y, 넷째날은 x + 2y, 다섯째날은 2x + 3y... 이렇게 진행된다.
DP로 x와 y의 계수를 구할 수 있기 때문에 D번째 날을 ax + by라고 하면 a와 b를 구할 수 있다.
따라서 x <= y이므로, x를 1부터 증가시키면서 y를 구해본다.

채점 결과 : 92ms/12300KB
풀이 날짜 : 2022/05/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = StringTokenizer(br.readLine())
    val d = input.nextToken().toInt()
    val k = input.nextToken().toInt()

    val firstCnt = IntArray(d + 1)
    val secondCnt = IntArray(d + 1)
    firstCnt[1] = 1
    secondCnt[2] = 1
    for (i in 3..d) {
        firstCnt[i] = firstCnt[i-1] + firstCnt[i-2]
        secondCnt[i] = secondCnt[i-1] + secondCnt[i-2]
    }

    var x = 1
    var y = 0
    while (true) {
        val exp = k - firstCnt[d] * x

        if (exp % secondCnt[d] == 0) {
            y = exp / secondCnt[d]
            break
        }

        x++
    }

    bw.write("$x\n$y")
    bw.close()
    br.close()
}