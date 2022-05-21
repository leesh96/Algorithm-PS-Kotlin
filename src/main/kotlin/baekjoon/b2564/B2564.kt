package baekjoon.b2564

import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 2564
문제제목 : 경비원
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 많은 조건 분기

알고리즘 설명
북, 남, 서, 동 순으로
동근이가 북쪽에 있을때 -> 상점거리 차이의 절대값, 시계와 반시계의 최소값, 반시계, 시계
동근이가 남쪽에 있을때 -> 시계와 반시계의 최소값, 상점거리 차이의 절대값, 시계, 반시계
동근이가 서쪽에 있을때 -> 시계, 반시계, 상점거리 차이의 절대값, 시계와 반시계의 최소값
동근이나 동쪽에 있을때 -> 반시계, 시계, 시계와 반시계의 최소값, 상점거리 차이의 절대값

채점 결과 : 92ms/12468KB
풀이 날짜 : 2022/05/21
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val width: Int
    val height: Int
    with(StringTokenizer(br.readLine())) {
        width = nextToken().toInt()
        height = nextToken().toInt()
    }
    val n = br.readLine().toInt()
    val stores = Array(n) { StringTokenizer(br.readLine()).run { Store(nextToken().toInt(), nextToken().toInt()) } }
    val dg = StringTokenizer(br.readLine()).run { Store(nextToken().toInt(), nextToken().toInt()) }

    var answer = 0

    // 북, 남, 서, 동
    when (dg.pos) {
        1 -> {
            for (i in 0 until n) {
                when (stores[i].pos) {
                    1 -> {
                        answer += abs(stores[i].dist - dg.dist)
                    }
                    2 -> {
                        answer += minOf(
                            dg.dist + height + stores[i].dist,                      // 반시계
                            (width - dg.dist) + height + (width - stores[i].dist)   // 시계
                        )
                    }
                    3 -> {
                        answer += dg.dist + stores[i].dist
                    }
                    4 -> {
                        answer += (width - dg.dist) + stores[i].dist
                    }
                }
            }
        }
        2 -> {
            for (i in 0 until n) {
                when (stores[i].pos) {
                    1 -> {
                        answer += minOf(
                            dg.dist + height + stores[i].dist,                      // 시계
                            (width - dg.dist) + height + (width - stores[i].dist)   // 반시계
                        )
                    }
                    2 -> {
                        answer += abs(stores[i].dist - dg.dist)
                    }
                    3 -> {
                        answer += dg.dist + (height - stores[i].dist)
                    }
                    4 -> {
                        answer += (width - dg.dist) + (height - stores[i].dist)
                    }
                }
            }
        }
        3 -> {
            for (i in 0 until n) {
                when (stores[i].pos) {
                    1 -> {
                        answer += dg.dist + stores[i].dist
                    }
                    2 -> {
                        answer += (height - dg.dist) + stores[i].dist
                    }
                    3 -> {
                        answer += abs(stores[i].dist - dg.dist)
                    }
                    4 -> {
                        answer += minOf(
                            dg.dist + width + stores[i].dist,                       // 시계
                            (height - dg.dist) + width + (height - stores[i].dist)  // 반시계
                        )
                    }
                }
            }
        }
        4 -> {
            for (i in 0 until n) {
                when (stores[i].pos) {
                    1 -> {
                        answer += dg.dist + (width - stores[i].dist)
                    }
                    2 -> {
                        answer += (height - dg.dist) + (width - stores[i].dist)
                    }
                    3 -> {
                        answer += minOf(
                            dg.dist + width + stores[i].dist,                       // 반시계
                            (height - dg.dist) + width + (height - stores[i].dist)  // 시계
                        )
                    }
                    4 -> {
                        answer += abs(stores[i].dist - dg.dist)
                    }
                }
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}

private class Store(val pos: Int, val dist: Int)