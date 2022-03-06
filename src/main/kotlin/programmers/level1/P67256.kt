package programmers.level1

import kotlin.math.abs

class P67256 {
    fun solution(numbers: IntArray, hand: String): String {
        var curLeft = 3 to 0
        var curRight = 3 to 2
        val answer = StringBuilder()
        numbers.forEach {
            when (it) {
                1, 4, 7 -> {
                    curLeft = it / 3 to 0
                    answer.append("L")
                }
                3, 6, 9 -> {
                    curRight = it / 3 - 1 to 2
                    answer.append("R")
                }
                2, 5, 8, 0 -> {
                    val target = if (it == 0) 11 / 3 to 1 else it / 3 to 1
                    val leftDist = getDist(curLeft, target)
                    val rightDist = getDist(curRight, target)

                    when {
                        leftDist < rightDist -> {
                            curLeft = target
                            answer.append("L")
                        }
                        leftDist > rightDist -> {
                            curRight = target
                            answer.append("R")
                        }
                        else -> {
                            if (hand == "left") {
                                curLeft = target
                                answer.append("L")
                            } else {
                                curRight = target
                                answer.append("R")
                            }
                        }
                    }
                }
            }
        }
        return answer.toString()
    }

    private fun getDist(position: Pair<Int, Int>, target: Pair<Int, Int>): Int =
        abs(position.first - target.first) + abs(position.second - target.second)
}