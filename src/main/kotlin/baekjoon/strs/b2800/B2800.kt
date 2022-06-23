package baekjoon.strs.b2800

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2800
문제제목 : 괄호 제거
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 자료 구조, 문자열, 스택, 재귀

알고리즘 설명
1. 괄호 쌍을 스택을 사용해서 찾고
2. 시작괄호-끝괄호의 인덱스 쌍을 리스트에 저장
3. 리스트의 원소들로 조합구하기
주의. 괄호를 아무것도 삭제 안한 것 제외

채점 결과 : 168ms/15888KB
풀이 날짜 : 2022/06/23
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var answer: TreeSet<String>

fun main() {
    val exp = br.readLine()
    val stack = Stack<Int>()
    val parenthesis = mutableListOf<Pair<Int, Int>>()

    for (i in exp.indices) {
        if (exp[i] == '(') {
            stack.push(i)
        } else if (exp[i] == ')') {
            val start = stack.pop()
            parenthesis.add(start to i)
        }
    }

    answer = TreeSet()
    val n = parenthesis.size
    val delete = BooleanArray(n)
    comb(n, delete, 0, parenthesis, exp)

    for (a in answer) {
        bw.write(a)
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun comb(n: Int, delete: BooleanArray, idx: Int, p: MutableList<Pair<Int, Int>>, exp: String) {
    if (idx == n) {
        val sb = StringBuilder()
        val delChar = BooleanArray(exp.length)
        for (i in 0 until n) {
            if (delete[i]) {
                delChar[p[i].first] = true
                delChar[p[i].second] = true
            }
        }
        for (i in exp.indices) {
            if (!delChar[i]) sb.append(exp[i])
        }
        if (sb.length != exp.length) answer.add(sb.toString())
        return
    }

    delete[idx] = true
    comb(n, delete, idx + 1, p, exp)
    delete[idx] = false
    comb(n, delete, idx + 1, p, exp)
}