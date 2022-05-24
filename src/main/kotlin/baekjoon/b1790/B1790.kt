package baekjoon.b1790

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1790
문제제목 : 수 이어 쓰기 2
난이도 : 실버 1
제한사항 : 2초/64MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
숫자를 이어붙일 때 규칙이 있음. -> 한 자리 수 9개, 두 자리 수는 90개...
k값이 어느 범위에 포함되는지 찾고 나머지 연산으로 실제 이어 붙인 숫자를 구함

채점 결과 : 92ms/12292KB
풀이 날짜 : 2022/05/24
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    var answer = 0L
    var length = 1L
    var count = 9L
    var check = k.toLong()

    while (check > count * length) {
        check -= (length * count)
        answer += count

        length++
        count *= 10
    }

    answer = (answer + 1) + ((check - 1) / length)

    if (answer > n) {
        bw.write("-1")
    } else {
        val index = ((check - 1) % length).toInt()
        bw.write("${answer.toString()[index]}")
    }

    bw.close()
    br.close()
}