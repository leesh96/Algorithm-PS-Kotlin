package baekjoon.strs.b16171

/*
플랫폼 : 백준
문제번호 : 16171
문제제목 : 나는 친구가 적다 (Small)
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 문자열

알고리즘 설명
1. 정규표현식으로 숫자 제거
2. contains() 사용

채점 결과 : 120ms/14552KB
풀이 날짜 : 2022/06/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var s = br.readLine()
    val keyword = br.readLine()

    s = s.replace(Regex("\\d"), "")

    if (s.contains(keyword)) {
        bw.write("1")
    } else {
        bw.write("0")
    }

    bw.close()
    br.close()
}