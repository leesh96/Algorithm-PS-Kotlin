package programmers.level2

import java.util.*

// 타겟 넘버

class P43165 {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(-1 to 0)

        while (queue.isNotEmpty()) {
            val (idx, sum) = queue.poll()
            val next = idx + 1

            if (next > numbers.lastIndex) {
                if (sum == target) answer++
                continue
            }

            queue.offer(next to sum + numbers[next])
            queue.offer(next to sum - numbers[next])
        }

        return answer
    }
}