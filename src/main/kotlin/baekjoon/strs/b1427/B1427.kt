package baekjoon.strs.b1427

/*
플랫폼 : 백준
문제번호 : 1427
문제제목 : 소트인사이드
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 문자열, 정렬

알고리즘 설명
1. 숫자별로 카운트해서 9부터 1개 이상인 것 출력

채점 결과 : 92ms/12408KB
풀이 날짜 : 2022/06/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()
    val counter = IntArray(10)

    for (c in input) {
        counter[c.digitToInt()]++
    }

    for (i in 9 downTo 0) {
        for (j in 1..counter[i]) {
            bw.write("$i")
        }
    }

    bw.close()
    br.close()
}