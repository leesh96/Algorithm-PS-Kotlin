package baekjoon.b17609

/*
플랫폼 : 백준
문제번호 : 17609
문제제목 : 회문
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 문자열, 두 포인터

알고리즘 설명
유사 팰린드롬을 확인할 때, 왼쪽에서 삭제했을 때와 오른쪽에서 삭제했을 때를 모두 확인
처음 다른 문자를 만났을 때 삭제해주면 된다.

채점 결과 : 256ms/38860KB
풀이 날짜 : 2022/05/25
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    repeat(t) {
        val input = br.readLine()
        bw.write("${check(input, 0, input.lastIndex, 0)}")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun check(str: String, left: Int, right: Int, delete: Int): Int {
    if (delete == 2) {
        return 2
    }

    var temp = delete
    var l = left
    var r = right
    while (l < r) {
        if (str[l] != str[r]) {
            temp = minOf(check(str, l + 1, r, delete + 1), check(str, l, r - 1, delete + 1))
            break
        }
        l++
        r--
    }
    return temp
}