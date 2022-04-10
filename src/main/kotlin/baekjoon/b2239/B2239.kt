package baekjoon.b2239

/*
플랫폼 : 백준
문제번호 : 2239
문제제목 : 스도쿠
난이도 : 골드 4
제한사항 : 2초/256MB
알고리즘 분류 : 구현, 백트래킹

알고리즘 설명
백트래킹

채점 결과 : 740ms/24672KB
풀이 날짜 : 2022/04/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var success = false

fun main() {
    val arr = Array(9) { br.readLine().map { it.digitToInt() }.toIntArray() }
    br.close()

    sudoku(arr, 0, 0)

    bw.close()
}

private fun sudoku(arr: Array<IntArray>, row: Int, col: Int) {
    if (success) return

    if (col == 9) {
        sudoku(arr, row + 1, 0)
        return
    }

    if (row == 9) {
        for (i in 0 until 9) {
            bw.write(arr[i].joinToString(""))
            bw.newLine()
        }
        success = true
        return
    }

    if (arr[row][col] == 0) {
        for (num in 1..9) {
            if (check(arr, row, col, num)) {
                arr[row][col] = num
                sudoku(arr, row, col + 1)
            }
        }
        arr[row][col] = 0
        return
    }

    sudoku(arr, row, col + 1)
}

private fun check(arr: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
    for (c in 0 until 9) {
        if (arr[row][c] == num) return false
    }

    for (r in 0 until 9) {
        if (arr[r][col] == num) return false
    }

    val rectRow = (row / 3) * 3
    val rectCol = (col / 3) * 3
    for (r in rectRow..rectRow + 2) {
        for (c in rectCol..rectCol + 2) {
            if (arr[r][c] == num) return false
        }
    }

    return true
}