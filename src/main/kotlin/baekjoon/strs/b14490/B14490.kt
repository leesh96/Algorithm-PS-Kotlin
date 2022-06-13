package baekjoon.strs.b14490

/*
플랫폼 : 백준
문제번호 : 14490
문제제목 : 백대열
난이도 : 실버 5
제한사항 : 2초/512MB
알고리즘 분류 : 수학, 문자열, 정수론, 파싱, 유클리드 호제법

알고리즘 설명
1. :으로 문자열을 split
2. 최대 공약수 구해서 약분 - 유클리드 호제법

채점 결과 : 132ms/20676KB
풀이 날짜 : 2022/06/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine().split(":").map { it.toInt() }
    val g = gcd(input[0], input[1])

    bw.write("${input[0] / g}:${input[1] / g}")
    bw.close()
    br.close()
}

private tailrec fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}