package baekjoon.strs.b1013

/*
플랫폼 : 백준
문제번호 : 1013
문제제목 : Contact
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 문자열, 정규표현식

알고리즘 설명
정규표현식 패턴 매칭

채점 결과 : 144ms/14528KB
풀이 날짜 : 2022/06/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    val regex = Regex("^(100+1+|01)+$")

    repeat(t) {
        val input = br.readLine()

        if (regex.matches(input)) bw.write("YES") else bw.write("NO")
        bw.newLine()
    }

    bw.close()
    br.close()
}