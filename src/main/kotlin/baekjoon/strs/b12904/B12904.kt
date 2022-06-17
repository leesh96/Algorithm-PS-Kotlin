package baekjoon.strs.b12904

/*
플랫폼 : 백준
문제번호 : 12904
문제제목 : A와 B
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 문자열, 그리디

알고리즘 설명
DP로 다루기엔 데이터가 까다로움(연산이 2개), 백트래킹은 시간초과
거꾸로 t 문자열을 s로 만드는 것 생각 -> 끝이 A이면 삭제, B이면 삭제하고 뒤집기

채점 결과 : 136ms/14580KB
풀이 날짜 : 2022/06/17
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = StringBuilder(br.readLine())
    val t = StringBuilder(br.readLine())

    while (t.length > s.length) {
        if (t.last() == 'A') {
            t.delete(t.lastIndex, t.length)
        } else {
            t.delete(t.lastIndex, t.length)
            t.reverse()
        }
    }

    if (t.contentEquals(s)) bw.write("1") else bw.write("0")

    bw.close()
    br.close()
}