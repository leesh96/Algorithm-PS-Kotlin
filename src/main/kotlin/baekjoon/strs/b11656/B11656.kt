package baekjoon.strs.b11656

/*
플랫폼 : 백준
문제번호 : 11656
문제제목 : 접미사 배열
난이도 : 실버 4
제한사항 : 1초/256MB
알고리즘 분류 : 문자열, 정렬

알고리즘 설명
1. subString
2. 정렬

채점 결과 : 168ms/26548KB
풀이 날짜 : 2022/06/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine()
    val answer = mutableListOf<String>()

    for (i in s.indices) {
        answer.add(s.substring(i))
    }

    answer.sort()

    bw.write(answer.joinToString("\n"))
    bw.close()
    br.close()
}