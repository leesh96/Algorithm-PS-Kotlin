package baekjoon.b1417

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1417
문제제목 : 국회의원 선거
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 자료구조, 그리디, 시뮬레이션, 우선순위 큐

알고리즘 설명
우선순위 큐에 다른 후보자들의 득표수를 넣어놓고, 맨 위의 득표수가 다솜의 득표수보다 작아질 때까지 꺼내고 넣고를 반복한다.

채점 결과 : 96ms/12376KB
풀이 날짜 : 2022/04/30
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>(Comparator.reverseOrder())
    var point = br.readLine().toInt()

    repeat(n-1) {
        pq.offer(br.readLine().toInt())
    }

    var answer = 0
    if (n != 1) {
        while (pq.peek() >= point) {
            val get = pq.poll()
            answer++
            point++
            pq.offer(get - 1)
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}