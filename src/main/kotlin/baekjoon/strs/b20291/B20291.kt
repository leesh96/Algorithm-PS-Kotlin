package baekjoon.strs.b20291

/*
플랫폼 : 백준
문제번호 : 20291
문제제목 : 파일 정리
난이도 : 실버 3
제한사항 : 3초/1024MB
알고리즘 분류 : 자료 구조, 문자열, 정렬, 파싱, 해시/트리 집합과 맵

알고리즘 설명
1. MAP 자료구조로 카운트
2. 키만 정렬해서 값을 출력

채점 결과 : 904ms/107732KB
풀이 날짜 : 2022/06/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val counter = mutableMapOf<String, Int>()

    repeat(n) {
        val fileName = br.readLine().split(".")
        counter[fileName[1]] = counter.getOrDefault(fileName[1], 0) + 1
    }

    val ext = counter.keys.toList().sorted()
    for (e in ext) {
        bw.write("$e ${counter[e]}")
        bw.newLine()
    }
    bw.close()
    br.close()
}