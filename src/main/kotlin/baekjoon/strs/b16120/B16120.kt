package baekjoon.strs.b16120

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16120
문제제목 : PPAP
난이도 : 골드 4
제한사항 : 1초/512MB
알고리즘 분류 : 자료 구조, 문자열, 그리디, 스택

알고리즘 설명
괄호 문자열과 비슷하게 스택으로 푼다.
1. P를 만나면 스택에 담는다.
2. 그외 문자를 만나면 앞에 P가 2개인지, 뒤에 P가 오는지 확인하고 스택에서 P 2개를 꺼낸다.
3. 마지막으로 스택에 P가 하나 남아있으면 PPAP

채점 결과 : 280ms/27260KB
풀이 날짜 : 2022/06/20
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine()

    if (isPPAP(s)) bw.write("PPAP") else bw.write("NP")
    bw.close()
    br.close()
}

private fun isPPAP(str: String): Boolean {
    val stack = Stack<Char>()
    for (i in str.indices) {
        val cur = str[i]

        if (cur == 'P') {
            stack.push('P')
        } else {
            if (stack.size >= 2 && i < str.lastIndex && str[i+1] == 'P') {
                stack.pop()
                stack.pop()
            } else {
                return false
            }
        }
    }

    return stack.size == 1
}