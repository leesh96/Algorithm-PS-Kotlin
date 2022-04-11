package programmers.level2

import java.util.*
import kotlin.math.abs

// 거리두기 확인하기

class P81302 {
    companion object {
        private val dr = intArrayOf(1, -1, 0, 0)
        private val dc = intArrayOf(0, 0, -1, 1)
    }

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(5)

        for (t in 0 until 5) {
            var flag = true
            outer@for (r in 0 until 5) {
                for (c in 0 until 5) {
                    if (places[t][r][c] == 'P') {
                        flag = check(places[t], r to c)
                    }
                    if (!flag) break@outer
                }
            }

            answer[t] = if (flag) 1 else 0
        }

        return answer
    }

    private fun check(room: Array<String>, start: Pair<Int, Int>): Boolean {
        val visit = Array(5) { BooleanArray(5) }
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(start)
        visit[start.first][start.second] = true

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            repeat(4) {
                val nr = cur.first + dr[it]
                val nc = cur.second + dc[it]

                if (nr in 0 until 5 && nc in 0 until 5 && !visit[nr][nc] && manhattanDist(
                        start.first,
                        nr,
                        start.second,
                        nc
                    ) <= 2
                ) {
                    visit[nr][nc] = true
                    if (room[nr][nc] == 'O') queue.offer(nr to nc)
                    else if (room[nr][nc] == 'P') return false
                }
            }
        }
        return true
    }

    private fun manhattanDist(r1: Int, r2: Int, c1: Int, c2: Int) = abs(r2 - r1) + abs(c2 - c1)
}