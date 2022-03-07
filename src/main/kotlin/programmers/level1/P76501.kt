package programmers.level1

// 음양 더하기

class P76501 {
    fun solution(absolutes: IntArray, signs: BooleanArray) =
        absolutes.zip(signs.asIterable()) { num: Int, sign: Boolean ->
            if (sign) num else -num
        }.sum()
}