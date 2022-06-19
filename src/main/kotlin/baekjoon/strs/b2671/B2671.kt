package baekjoon.strs.b2671

/*
플랫폼 : 백준
문제번호 : 2671
문제제목 : 잠수함식별
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 정규표현식

알고리즘 설명
정규표현식 패턴 매칭

채점 결과 : 96ms/12860KB
풀이 날짜 : 2022/06/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine()
    val regex = Regex("^(100+1+|01)+$")

    if (s.matches(regex)) bw.write("SUBMARINE") else bw.write("NOISE")

    bw.close()
    br.close()
}