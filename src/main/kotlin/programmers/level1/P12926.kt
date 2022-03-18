package programmers.level1

// 시저 암호

class P12926 {
    fun solution(s: String, n: Int): String {
        return s.map {
            when (it) {
                in 'a'..'z' -> {
                    val gap = it - 'a'
                    'a' + (n + gap) % 26
                }
                in 'A'..'Z' -> {
                    val gap = it - 'A'
                    'A' + (n + gap) % 26
                }
                else -> it
            }
        }.joinToString("")
    }
}