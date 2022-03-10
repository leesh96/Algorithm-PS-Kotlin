package programmers.level1

// 나머지가 1이 되는 수 찾기

class P87389 {
    fun solution(n: Int) = (1..n).first { n % it == 1 }
}