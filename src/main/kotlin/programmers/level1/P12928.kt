package programmers.level1

// 약수의 합

class P12928 {
    fun solution(n: Int) =
        (1..n).filter { n % it == 0 }.sum()
}