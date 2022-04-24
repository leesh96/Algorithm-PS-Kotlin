package baekjoon.b16922

/*
플랫폼 : 백준
문제번호 : 16922
문제제목 : 로마 숫자 만들기
난이도 : 실버 3
제한사항 : 2초/512MB
알고리즘 분류 : 수학, 구현, 브루트포스 알고리즘, 조합론, 백트래킹

알고리즘 설명
중복 조합

채점 결과 : 96ms/13672KB
풀이 날짜 : 2022/04/24
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var set: MutableSet<Int>
private val nums = intArrayOf(1, 5, 10, 50)

private var n = 0

fun main() {
    n = br.readLine().toInt()
    set = mutableSetOf<Int>()

    repeatComb(0, 0, 0)

    bw.write("${set.size}")
    bw.close()
    br.close()
}

private fun repeatComb(depth: Int, idx: Int, sum: Int) {
    if (depth == n) {
        set.add(sum)
        return
    }

    for (i in idx until 4) {
        repeatComb(depth + 1, i, sum + nums[i])
    }
}