package baekjoon.b16935

import java.util.*

/*
플랫폼 : 백준
문제번호 : 16935
문제제목 : 배열 돌리기 3
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 구현

알고리즘 설명
배열 회전 케이스 구현..
배열 회전 문제 인덱스 판단하기 연습 좋은 문제

채점 결과 : 572ms/65028KB
풀이 날짜 : 2022/05/27
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

var n = 0
var m = 0

fun main() {
    val r: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        r = nextToken().toInt()
    }

    var arr = Array(n) { StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } } }

    with(StringTokenizer(br.readLine())) {
        repeat(r) {
            val op = nextToken().toInt()
            arr = when (op) {
                1 -> op1(arr)
                2 -> op2(arr)
                3 -> op3(arr)
                4 -> op4(arr)
                5 -> op5(arr)
                else -> op6(arr)
            }
        }
    }

    for (i in 0 until n) {
        bw.write(arr[i].joinToString(" ", postfix = "\n"))
    }

    bw.close()
    br.close()
}

private fun op1(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(n) { IntArray(m) }

    for (r in 0 until n) {
        for (c in 0 until m) {
            res[n-r-1][c] = arr[r][c]
        }
    }
    return res
}

private fun op2(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(n) { IntArray(m) }

    for (r in 0 until n) {
        for (c in 0 until m) {
            res[r][m-c-1] = arr[r][c]
        }
    }

    return res
}

private fun op3(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(m) { IntArray(n) }

    var col = n - 1
    for (r in 0 until n) {
        for (c in 0 until m) {
            res[c][col] = arr[r][c]
        }
        col--
    }

    n = m.also { m = n }

    return res
}

private fun op4(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(m) { IntArray(n) }

    for (r in 0 until n) {
        for (c in 0 until m) {
            res[m-c-1][r] = arr[r][c]
        }
    }

    n = m.also { m = n }

    return res
}

private fun op5(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(n) { IntArray(m) }

    val halfN = n / 2
    val halfM = m / 2

    for (r in 0 until halfN) {
        for (c in 0 until halfM) {
            res[r][c+halfM] = arr[r][c]
        }
    }

    for (r in 0 until halfN) {
        for (c in halfM until m) {
            res[r+halfN][c] = arr[r][c]
        }
    }

    for (r in halfN until n) {
        var col = 0
        for (c in halfM until m) {
            res[r][col] = arr[r][c]
            col++
        }
    }

    var row = 0
    for (r in halfN until n) {
        for (c in 0 until halfM) {
            res[row][c] = arr[r][c]
        }
        row++
    }

    return res
}

private fun op6(arr: Array<IntArray>): Array<IntArray> {
    val res = Array(n) { IntArray(m) }

    val halfN = n / 2
    val halfM = m / 2

    for (r in 0 until halfN) {
        for (c in 0 until halfM) {
            res[r+halfN][c] = arr[r][c]
        }
    }

    for (r in halfN until n) {
        for (c in 0 until halfM) {
            res[r][c+halfM] = arr[r][c]
        }
    }

    var row = 0
    for (r in halfN until n) {
        for (c in halfM until m) {
            res[row][c] = arr[r][c]
        }
        row++
    }

    for (r in 0 until halfN) {
        var col = 0
        for (c in halfM until m) {
            res[r][col] = arr[r][c]
            col++
        }
    }

    return res
}