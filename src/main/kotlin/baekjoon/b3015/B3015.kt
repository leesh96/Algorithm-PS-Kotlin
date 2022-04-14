package baekjoon.b3015

import java.util.*

/*
플랫폼 : 백준
문제번호 : 3015
문제제목 : 오아시스 재결합
난이도 : 골드 1
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 스택

알고리즘 설명
스택에 줄 순서로 넣고 top(바로 앞의 사람)의 키와 비교한다.
스택에 넣을 때 같은 키의 사람이 몇 번 등장했는지도 카운트해서 넣어야 한다.

채점 결과 : 520ms
풀이 날짜 : 2022/04/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val stack = Stack<Pair<Int, Int>>()
    var answer = 0L
    repeat(n) {
        val h = br.readLine().toInt()
        var count = 1

        while (stack.isNotEmpty() && stack.peek().first <= h) {
            val top = stack.pop()
            answer += top.second
            if (top.first == h) count += top.second
        }

        if (stack.isNotEmpty()) {
            answer++
        }

        stack.push(h to count)
    }

    bw.write("$answer")
    bw.close()
    br.close()
}