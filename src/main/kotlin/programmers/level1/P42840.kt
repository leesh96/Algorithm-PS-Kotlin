package programmers.level1

// 모의고사

class P42840 {
    fun solution(answers: IntArray): IntArray {
        val one = intArrayOf(1, 2, 3, 4, 5)
        val two = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val three = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val scores = mutableListOf<Pair<Int, Int>>().apply {
            add(1 to answers.filterIndexed { index, i -> i == one[index % 5] }.count())
            add(2 to answers.filterIndexed { index, i -> i == two[index % 8] }.count())
            add(3 to answers.filterIndexed { index, i -> i == three[index % 10] }.count())
        }.sortedByDescending { it.second }
        val max = scores[0].second
        return scores.filter { it.second == max }.map { it.first }.toIntArray()
    }
}