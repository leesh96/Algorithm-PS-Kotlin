package baekjoon.strs.b15904

/*
플랫폼 : 백준
문제번호 : 15904
문제제목 : UCPC는 무엇의 약자일까?
난이도 : 실버 5
제한사항 : 1초/512MB
알고리즘 분류 : 문자열, 그리디 알고리즘

알고리즘 설명
앞에서부터 U, C, P, C가 순서대로 등장하는지만 체크하면 된다.

채점 결과 : 96ms/12288KB
풀이 날짜 : 2022/06/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()
    bw.write(checkStr(input))
    bw.close()
    br.close()
}

private fun checkStr(str: String): String {
    val target = charArrayOf('U', 'C', 'P', 'C')

    var index = 0
    for (c in str) {
        if (c == target[index]) {
            index++
        }

        if (index == 4) {
            return "I love UCPC"
        }
    }

    return "I hate UCPC"
}