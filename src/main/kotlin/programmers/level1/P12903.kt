package programmers.level1

// 가운데 글자 가져오기

class P12903 {
    fun solution(s: String): String =
        if (s.length % 2 == 0) s.substring(s.length / 2 - 1..s.length / 2)
        else s[s.length / 2].toString()
}