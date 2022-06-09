package baekjoon.strs.b14405

/*
플랫폼 : 백준
문제번호 : 14405
문제제목 : 피카츄
난이도 : 실버 5
제한사항 : 2초/512MB
알고리즘 분류 : 문자열, 정규표현식

알고리즘 설명
1. 정규표현식 사용
다른 풀이: 브루트포스 알고리즘, replaceAll

채점 결과 : 100ms/12844KB
풀이 날짜 : 2022/06/09
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()
    val regex = Regex("^(pi|ka|chu)*$")

    bw.write(if (input.matches(regex)) "YES" else "NO")
    bw.close()
    br.close()
}