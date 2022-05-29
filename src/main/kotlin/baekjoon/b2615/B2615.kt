package baekjoon.b2615

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2615
문제제목 : 오목
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 가장 왼쪽 좌표가 필요하기 때문에 우상, 우, 우하, 하 4방향만 체크
2. 6목의 경우 체크 -> 4방향에서 5개 이상으로 진행되거나, 4방향의 반대방향으로 하나이상 같거나.
3. 1.번 경우의 반환값이 5이고, 역방향 체크가 같은 색이 아님
4. 모든 좌표, 모든 방향에 대해 완전탐색 또는 같은 방향마다 방문배열, 풀이는 전자

채점 결과 : 100ms/12464KB
풀이 날짜 : 2022/05/29
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val END = 19

private val dr = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
private val dc = intArrayOf(1, 1, 1, 0, -1, -1, -1, 0)

fun main() {
    val arr = Array(END) { StringTokenizer(br.readLine()).run { IntArray(END) { nextToken().toInt() } } }

    var flag = false
    check@ for (r in 0 until END) {
        for (c in 0 until END) {
            if (arr[r][c] != 0) {
                for (k in 0 until 4) {
                    if (check(arr, r, c, arr[r][c], k) == 5 && !reverseCheck(arr, r, c, arr[r][c], k + 4)) {
                        flag = true
                        bw.write("${arr[r][c]}")
                        bw.newLine()
                        bw.write("${r + 1} ${c + 1}")
                        break@check
                    }
                }
            }
        }
    }

    if (!flag) {
        bw.write("0")
    }

    bw.close()
    br.close()
}

private fun check(arr: Array<IntArray>, r: Int, c: Int, color: Int, dir: Int): Int {
    var nr = r + dr[dir]
    var nc = c + dc[dir]
    var count = 1

    while (true) {
        if (nr !in 0 until END || nc !in 0 until END || arr[nr][nc] != color) {
            break
        }
        count++
        nr += dr[dir]
        nc += dc[dir]
    }

    return count
}

private fun reverseCheck(arr: Array<IntArray>, r: Int, c: Int, color: Int, dir: Int): Boolean {
    val reverseR = r + dr[dir]
    val reverseC = c + dc[dir]
    return reverseR in 0 until END && reverseC in 0 until END && arr[reverseR][reverseC] == color
}