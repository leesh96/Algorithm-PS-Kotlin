package baekjoon.b16926

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16926
문제제목 : 배열 돌리기 1
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 구현

알고리즘 설명
1. 한 사이클을 이루는 사각형 단위로 회전
2. 회전은 방향과 swap을 통해 수행

채점 결과 : 696ms/40280KB
풀이 날짜 : 2022/05/18
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(1, 0, -1, 0)
private val dc = intArrayOf(0, 1, 0, -1)

fun main() {
    val nmr = StringTokenizer(br.readLine())
    val n = nmr.nextToken().toInt()
    val m = nmr.nextToken().toInt()
    val rotate = nmr.nextToken().toInt()

    val arr = Array(n) { StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } } }

    val depth = minOf(n, m) / 2

    repeat(rotate) {
        for (start in 0 until depth) {
            var r = start
            var c = start
            var dir = 0
            var prev = arr[r][c]

            while (dir < 4) {
                val nr = r + dr[dir]
                val nc = c + dc[dir]

                if (nr in start until n - start && nc in start until m - start) {
                    arr[nr][nc] = prev.also { prev = arr[nr][nc] }
                    r = nr
                    c = nc
                } else {
                    dir++
                }
            }
        }
    }

    for (i in 0 until n) {
        bw.write(arr[i].joinToString(" ", postfix = "\n"))
    }
    bw.close()
    br.close()
}