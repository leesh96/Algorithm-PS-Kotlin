package programmers.level1

// 이상한 문자 만들기

class P12930 {
    fun solution(s: String) =
        s.split(" ").joinToString(" ") { str ->
            str.mapIndexed { index, c ->
                if (index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
            }.joinToString("")
        }
}