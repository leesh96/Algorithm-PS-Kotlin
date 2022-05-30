package baekjoon.b9996

/*
플랫폼 : 백준
문제번호 : 9996
문제제목 : 한국이 그리울 땐 서버에 접속하지
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 브루트포스 알고리즘, 정규 표현식

알고리즘 설명
startsWith와 endsWith 활용

채점 결과 : 120ms/14400KB
풀이 날짜 : 2022/05/30
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val pattern = br.readLine().split("*")

    for (i in 0 until n) {
        val check = br.readLine()

        if (check.length < pattern[0].length + pattern[1].length) {
            bw.write("NE\n")
            continue
        }

        if (check.startsWith(pattern[0]) && check.endsWith(pattern[1])) {
            bw.write("DA\n")
        } else {
            bw.write("NE\n")
        }
    }

    bw.close()
    br.close()
}