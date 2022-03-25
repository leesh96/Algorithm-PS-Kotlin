package programmers.level1

// x만큼 간격이 있는 n개의 숫자

class P12954 {
    fun solution(x: Int, n: Int): LongArray {
        return LongArray(n) { idx -> x.toLong() * (idx + 1) }
    }
}