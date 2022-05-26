package baekjoon.b1254

/*
플랫폼 : 백준
문제번호 : 1254
문제제목 : 팰린드롬 만들기
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 문자열, 브루트포스 알고리즘

알고리즘 설명
문자열의 첫 인덱스부터 한 문자씩 버려가면서 부분 문자열이 팰린드롬인지 체크
문자열의 길이에 처음 팰린드롬으로 판별된 부분 문자열의 인덱스를 더해준다.

채점 결과 : 108ms/14268KB
풀이 날짜 : 2022/05/26
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = br.readLine()

    for (i in input.indices) {
        if (isPalindrome(input, i)) {
            bw.write("${input.length + i - 0}")
            break
        }
    }

    bw.close()
    br.close()
}

private fun isPalindrome(str: String, start: Int): Boolean {
    var left = start
    var right = str.lastIndex

    while (left <= right) {
        if (str[left] != str[right]) return false
        left++
        right--
    }

    return true
}