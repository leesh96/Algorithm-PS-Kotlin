package programmers.level1

// 실패율

class P42889 {
    fun solution(n: Int, stages: IntArray): IntArray {
        val answer = mutableListOf<Pair<Int, Double>>()
        var user = stages.count()
        for (stage in 1..n) {
            val clearUser = stages.count { it == stage }

            val fail = if (clearUser == 0) 0.0 else clearUser / user.toDouble()

            answer.add(stage to fail)
            user -= clearUser
        }
        answer.sortByDescending { it.second }
        return answer.map { it.first }.toIntArray()
    }
}