package baekjoon.strs.b7490

import java.util.*

/*
플랫폼 : 백준
문제번호 : 7490
문제제목 : 0 만들기
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열, 브루트포스 알고리즘, 파싱, 백트래킹

알고리즘 설명
1. 재귀로 수식 만들기
2. 공백을 없애 숫자를 붙이고 연산자로 분리
3. 수식 계산
주의: 아스키 순서에 따라 결과를 출력해야 하므로 재귀로 수식을 만들때 공백, +, - 순서로 한다.

채점 결과 : 232ms/24920KB
풀이 날짜 : 2022/06/21
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var answer: StringBuilder

fun main() {
    answer = StringBuilder()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        comb(n, 1, "1")
        answer.append("\n")
    }

    bw.write(answer.toString())
    bw.close()
    br.close()
}

private fun comb(n: Int, num: Int, exp: String) {
    if (num == n) {
        if (calcExp(exp) == 0) {
            answer.append("$exp\n")
        }
        return
    }

    comb(n, num + 1, "$exp ${num+1}")
    comb(n, num + 1, "$exp+${num+1}")
    comb(n, num + 1, "$exp-${num+1}")
}

private fun calcExp(exp: String): Int {
    val st = StringTokenizer(exp.replace(" ", ""), "+|-", true)
    var sum = st.nextToken().toInt()
    while (st.hasMoreTokens()) {
        val op = st.nextToken()
        if (op == "+") {
            sum += st.nextToken().toInt()
        } else {
            sum -= st.nextToken().toInt()
        }
    }

    return sum
}