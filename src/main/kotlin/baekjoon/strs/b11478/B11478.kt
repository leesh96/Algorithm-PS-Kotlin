package baekjoon.strs.b11478

/*
플랫폼 : 백준
문제번호 : 11478
문제제목 : 서로 다른 부분 문자열의 개수
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

알고리즘 설명
1. 부분문자열을 찾는 것은 브루트포스 알고리즘으로..
2. 세트 자료구조로 중복 제거

채점 결과 : 1028ms/564668KB
풀이 날짜 : 2022/06/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()
    val set = mutableSetOf<String>()

    for (i in input.indices) {
        for (j in i+1..input.length) {
            set.add(input.substring(i, j))
        }
    }

    bw.write("${set.size}")
    bw.close()
    br.close()
}