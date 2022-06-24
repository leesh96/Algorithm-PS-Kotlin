package baekjoon.strs.b9324

/*
플랫폼 : 백준
문제번호 : 9324
문제제목 : 진짜 메시지
난이도 : 실버 5
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열, 파싱

알고리즘 설명
1. 문자열의 문자를 읽으면서 알파벳 수를 센다.
2. 문자가 3개 등장했을때 다음 문자가 같은 알파벳인지 확인

채점 결과 : 296ms/48344KB
풀이 날짜 : 2022/06/24
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()

    repeat(t) {
        val str = br.readLine()
        if (check(str)) bw.write("OK") else bw.write("FAKE")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun check(str: String): Boolean {
    val count = IntArray(26)

    var i = 0
    while (i in str.indices) {
        val cur = str[i] - 'A'
        count[cur]++

        if (count[cur] == 3) {
            if (i == str.lastIndex) return false
            if (str[i] == str[i+1]) {
                count[cur] = 0
                i++
            } else {
                return false
            }
        }

        i++
    }

    return true
}