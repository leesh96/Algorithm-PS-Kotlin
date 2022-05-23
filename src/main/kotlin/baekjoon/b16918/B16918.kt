package baekjoon.b16918

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16918
문제제목 : 봄버맨
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 그래프 이론, 그래프 탐색, 시뮬레이션

알고리즘 설명
1. 폭탄의 상태(O, .)를 입력받는 입력 배열
2. 폭탄이 터질 시간을 표시하는 배열
3. 2초에 폭탄설치, 3초에 폭탄 터짐(처음 폭탄), 4초에 폭탄 설치, 5초에 폭탄 터짐(2초 설치)...
4. 짝수 시간에 폭탄 설치, 홀수 시간에 폭탄 터짐 -> 연쇄 폭발

채점 결과 : 344ms/21972KB
풀이 날짜 : 2022/05/23
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(1, -1, 0, 0)
private val dc = intArrayOf(0, 0, 1, -1)

fun main() {
    val r: Int
    val c: Int
    val n: Int
    with(StringTokenizer(br.readLine())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
        n = nextToken().toInt()
    }

    val bombs = Array(r) { br.readLine().toCharArray() }
    val explodes = Array(r) { i ->
        IntArray(c) { j ->
            if (bombs[i][j] == 'O') {
                3
            } else {
                0
            }
        }
    }

    var time = 0
    while (true) {
        if (time >= n) break

        time++

        if (time % 2 == 0) {
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (bombs[i][j] == '.') {
                        bombs[i][j] = 'O'
                        explodes[i][j] = time + 3
                    }
                }
            }
        } else if (time % 2 == 1) {
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (explodes[i][j] == time) {
                        bombs[i][j] = '.'
                        repeat(4) {
                            val nr = i + dr[it]
                            val nc = j + dc[it]

                            if (nr in 0 until r && nc in 0 until c && bombs[nr][nc] == 'O' && explodes[nr][nc] != time) {
                                bombs[nr][nc] = '.'
                                explodes[nr][nc] = 0
                            }
                        }
                    }
                }
            }
        }
    }

    for (i in 0 until r) {
        bw.write(bombs[i].joinToString("", postfix = "\n"))
    }
    bw.close()
    br.close()
}