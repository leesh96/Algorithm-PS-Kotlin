package baekjoon.strs.b16916

/*
플랫폼 : 백준
문제번호 : 16916
문제제목 : 부분 문자열
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 문자열, KMP

알고리즘 설명
완전탐색 -> 시간초과
KMP 알고리즘 사용

채점 결과 : 284ms/30904KB
풀이 날짜 : 2022/06/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val s = br.readLine()
    val p = br.readLine()

    val table = preprocessing(p)
    if (kmp(s, p, table)) bw.write("1") else bw.write("0")

    bw.close()
    br.close()
}

private fun isSubString(s: String, p: String): Boolean {
    for (i in 0..s.length - p.length) {
        if (s.substring(i, i + p.length) == p) return true
    }

    return false
}

private fun preprocessing(pattern: String): IntArray {
    val m = pattern.length
    val ret = IntArray(m)

    var match = 0
    for (begin in 1 until m) {
        while (match > 0 && pattern[begin] != pattern[match]) {
            match = ret[match - 1]
        }

        if (pattern[begin] == pattern[match]) {
            match++
            ret[begin] = match
        }
    }

    return ret
}

private fun kmp(str: String, pattern: String, table: IntArray): Boolean {
    val n = str.length
    val m = pattern.length

    var j = 0
    for (i in 0 until n) {
        while (j > 0 && str[i] != pattern[j]) {
            j = table[j - 1]
        }

        if (str[i] == pattern[j]) {
            if (j == m - 1) return true
            else j++
        }
    }

    return false
}