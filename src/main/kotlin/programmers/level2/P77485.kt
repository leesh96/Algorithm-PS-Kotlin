package programmers.level2

// 행렬 테두리 회전하기

class P77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        val array = Array(rows) { r ->
            IntArray(columns) { c ->
                (r * columns) + (c + 1)
            }
        }

        for ((x1, y1, x2, y2) in queries) {
            val rStart = x1 - 1
            val cStart = y1 - 1
            val rEnd = x2 - 1
            val cEnd = y2 - 1

            var r = rStart
            var c = cStart
            var move = array[r][c]
            var minNum = move

            // 윗줄
            while (c < cEnd) {
                array[r][c+1] = move.also { move = array[r][c+1] }
                minNum = minOf(minNum, move)
                c++
            }
            c = cEnd
            // 오른쪽 열
            while (r < rEnd) {
                array[r+1][c] = move.also { move = array[r+1][c] }
                minNum = minOf(minNum, move)
                r++
            }
            r = rEnd
            // 아랫줄
            while (c > cStart) {
                array[r][c-1] = move.also { move = array[r][c-1] }
                minNum = minOf(minNum, move)
                c--
            }
            c = cStart
            // 왼쪽 열
            while (r > rStart) {
                array[r-1][c] = move.also { move = array[r-1][c] }
                minNum = minOf(minNum, move)
                r--
            }

            answer.add(minNum)
        }

        return answer.toIntArray()
    }
}