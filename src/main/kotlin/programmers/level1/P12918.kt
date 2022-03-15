package programmers.level1

// 문자열 다루기 기본

class P12918 {
    fun solution(s: String): Boolean {
        if (s.length == 4 || s.length == 6) {
            if (s.none { it !in '0'..'9' }) {
                return true
            }
        }
        return false
    }
}