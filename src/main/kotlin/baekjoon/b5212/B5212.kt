package baekjoon.b5212

import java.util.*

/*
플랫폼 : 백준
문제번호 : 5212
문제제목 : 지구 온난화
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
50년후의 상태를 저장할 새로운 배열을 만들어야 한다.

채점 결과 : 176ms/26252KB
풀이 날짜 : 2022/05/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

fun main() {
    val r: Int
    val c: Int
    with(StringTokenizer(br.readLine())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
    }

    val map = Array(r) { br.readLine().toCharArray() }
    val next50 = Array(r) { CharArray(c) }
    var minR = r - 1
    var maxR = 0
    var minC = c - 1
    var maxC = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (map[i][j] == 'X') {
                var count = 0
                for (dir in 0 until 4) {
                    val nr = i + dr[dir]
                    val nc = j + dc[dir]

                    if (nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc] == '.') {
                        count++
                    }
                }

                if (count < 3) {
                    next50[i][j] = 'X'
                    minR = minOf(minR, i)
                    maxR = maxOf(maxR, i)
                    minC = minOf(minC, j)
                    maxC = maxOf(maxC, j)
                } else {
                    next50[i][j] = '.'
                }
            } else {
                next50[i][j] = '.'
            }
        }
    }

    for (i in minR..maxR) {
        bw.write(next50[i].slice(minC..maxC).joinToString("", postfix = "\n"))
    }

    bw.close()
    br.close()
}