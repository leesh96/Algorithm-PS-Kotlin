package baekjoon.strs.b13417

import java.util.*

/*
플랫폼 : 백준
문제번호 : 13417
문제제목 : 카드 문자열
난이도 : 실버 4
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 문자열, 그리디

알고리즘 설명
1. 덱을 만들고
2. 처음엔 그냥 삽입
3. 덱의 맨 앞의 알파벳보다 작거나 같으면 앞에, 아니면 뒤에 넣는다.

채점 결과 : 376ms/31576KB
풀이 날짜 : 2022/06/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val input = br.readLine().split(" ")
        val deque = LinkedList<String>()

        for (i in 0 until n) {
            if (deque.isEmpty()) {
                deque.offerLast(input[i])
                continue
            }

            if (deque.peekFirst() >= input[i]) deque.offerFirst(input[i]) else deque.offerLast(input[i])
        }

        bw.write(deque.joinToString(""))
        bw.newLine()
    }

    bw.close()
    br.close()
}