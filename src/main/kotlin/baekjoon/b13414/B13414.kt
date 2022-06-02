package baekjoon.b13414

import java.util.*

/*
플랫폼 : 백준
문제번호 : 13414
문제제목 : 수강신청
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 자료 구조, 해시를 사용한 집합과 맵

알고리즘 설명
저장 순서를 기억하는 LinkedHashSet 사용

채점 결과 : 736ms/80048KB
풀이 날짜 : 2022/06/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val k: Int
    val l: Int
    with(StringTokenizer(br.readLine())) {
        k = nextToken().toInt()
        l = nextToken().toInt()
    }

    val request = LinkedHashSet<String>()
    repeat(l) {
        val cur = br.readLine()
        if (request.contains(cur)) {
            request.remove(cur)
        }
        request.add(cur)
    }

    bw.write(request.take(k).joinToString("\n"))
    bw.close()
    br.close()
}