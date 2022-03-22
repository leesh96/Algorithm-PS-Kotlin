package programmers.level1

// 자릿수 더하기

class P12931 {
    fun solution(n: Int): Int {
        var num = n
        var sum = 0
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        return sum
    }
}