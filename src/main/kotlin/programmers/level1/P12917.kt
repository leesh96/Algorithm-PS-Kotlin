package programmers.level1

// 문자열 내림차순으로 배치하기

class P12917 {
    fun solution(s: String) = s.asIterable().sortedDescending().joinToString("")
}