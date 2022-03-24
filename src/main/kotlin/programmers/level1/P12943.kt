package programmers.level1

// 콜라츠 추측

class P12943 {
    fun solution(num: Int): Int {
        var answer = 0
        var n = num.toLong()

        while (answer < 500) {
            if (n == 1L) break

            when (n % 2) {
                0L -> {
                    n /= 2
                    answer++
                }
                1L -> {
                    n *= 3
                    n++
                    answer++
                }
            }
        }

        return if (n == 1L) answer else -1
    }
}