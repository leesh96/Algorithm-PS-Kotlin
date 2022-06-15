package baekjoon.strs.b3568

import java.util.*

/*
플랫폼 : 백준
문제번호 : 3568
문제제목 : iSharp
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 파싱

알고리즘 설명
문자열 파싱

채점 결과 : 92ms/12352KB
풀이 날짜 : 2022/06/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = StringTokenizer(br.readLine())

    val basicType = input.nextToken()
    while (input.hasMoreTokens()) {
        val cur = input.nextToken()
        val stack = Stack<Char>()
        val name = StringBuilder()
        for (c in cur) {
            if (c == ',' || c == ';') {
                break
            }

            if (isAlpha(c)) {
                name.append(c)
            } else {
                stack.push(c)
            }
        }

        val type = if (stack.isEmpty()) basicType else "$basicType${makeFullType(stack)}"

        bw.write("$type $name;")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun isAlpha(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'

private fun makeFullType(stack: Stack<Char>): String {
    val sb = StringBuilder()

    while (stack.isNotEmpty()) {
        if (stack.peek() == ']') {
            val close = stack.pop()
            sb.append(stack.pop())
            sb.append(close)
        } else {
            sb.append(stack.pop())
        }
    }

    return sb.toString()
}