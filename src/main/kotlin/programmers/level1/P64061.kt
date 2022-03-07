package programmers.level1

import java.util.*

// 크레인 인형뽑기 게임

class P64061 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val crane = Array(board.size) { LinkedList<Int>() }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != 0) crane[j].add(board[i][j])
            }
        }

        val stack = Stack<Int>()
        var answer = 0
        moves.map {
            it - 1
        }.forEach { idx ->
            if (crane[idx].isNotEmpty()) {
                val cur = crane[idx].poll()
                if (stack.isNotEmpty() && stack.peek() == cur) {
                    stack.pop()
                    answer += 2
                } else {
                    stack.push(cur)
                }
            }
        }
        return answer
    }
}