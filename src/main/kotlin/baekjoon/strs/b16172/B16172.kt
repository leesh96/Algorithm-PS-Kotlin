package baekjoon.strs.b16172

/*
플랫폼 : 백준
문제번호 : 16172
문제제목 : 나는 친구가 적다 (Large)
난이도 : 골드 3
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, KMP

알고리즘 설명
1. 문자열 길이가 길기 때문에 완전 탐색 대신 KMP 사용

채점 결과 : 268ms/22440KB
풀이 날짜 : 2022/06/26
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine()
    val p = br.readLine()

    val table = makeKMPTable(p)
    if (kmp(s.replace(Regex("\\d"), ""), p, table)) bw.write("1") else bw.write("0")

    bw.close()
    br.close()
}

private fun makeKMPTable(pattern: String): IntArray {
    val m = pattern.length
    val ret = IntArray(m)

    var match = 0
    for (begin in 1 until m) {
        while (match > 0 && pattern[begin] != pattern[match]) {
            match = ret[match - 1]
        }

        if (pattern[begin] == pattern[match]) {
            match += 1
            ret[begin] = match
        }
    }

    return ret
}

private fun kmp(s: String, p: String, table: IntArray): Boolean {
    val n = s.length
    val m = p.length

    var j = 0
    for (i in 0 until n) {
        while (j > 0 && s[i] != p[j]) {
            j = table[j - 1]
        }

        if (s[i] == p[j]) {
            if (j == m - 1) return true
            else j++
        }
    }

    return false
}