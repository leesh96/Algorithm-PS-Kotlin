package programmers.level2

// 메뉴 리뉴얼

class P72411 {
    private lateinit var map: MutableMap<String, Int>
    private var maxCount = 0

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        val sortedOrders = orders.map { it.toCharArray().sortedArray() }
        for (r in course) {
            map = mutableMapOf<String, Int>()
            maxCount = 0
            for (order in sortedOrders) {
                if (order.size < r) continue
                comb(order, CharArray(r), r, 0, 0)
            }
            if (maxCount > 1) {
                for (c in map.keys) {
                    if (map[c] == maxCount) {
                        answer.add(c)
                    }
                }
            }
        }

        return answer.sorted().toTypedArray()
    }

    private fun comb(order: CharArray, result: CharArray, r: Int, depth: Int, idx: Int) {
        if (depth == r) {
            val temp = result.concatToString()
            map[temp] = map.getOrDefault(temp, 0) + 1
            maxCount = maxOf(maxCount, map[temp] ?: 0)
            return
        }

        for (i in idx..order.lastIndex) {
            result[depth] = order[i]
            comb(order, result, r, depth + 1, i + 1)
        }
    }
}