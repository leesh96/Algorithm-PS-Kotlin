package programmers.level2

import java.util.*

// 기능개발

class P42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val remains = IntArray(progresses.size) {
            val remain = 100 - progresses[it]
            (remain / speeds[it]) + if (remain % speeds[it] == 0) 0 else 1
        }

        val queue = LinkedList<Int>()
        var idx = 0
        while (idx <= remains.lastIndex) {
            val cur = remains[idx]
            var count = 0
            while (idx <= remains.lastIndex && remains[idx] <= cur) {
                count++
                idx++
            }
            queue.offer(count)
        }

        return queue.toIntArray()
    }
}