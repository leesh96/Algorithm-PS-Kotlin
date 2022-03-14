package programmers.level1

// 나누어 떨어지는 숫자 배열

class P12910 {
    fun solution(arr: IntArray, divisor: Int) =
        arr.filter { it % divisor == 0 }.toMutableList().apply {
            if (isEmpty()) {
                add(-1)
            } else {
                sort()
            }
        }.toIntArray()
}