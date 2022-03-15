package programmers.level1

// 문자열 내 마음대로 정렬하기

class P12915 {
    fun solution(strings: Array<String>, n: Int) = strings.sorted().sortedBy { it[n] }.toTypedArray()
}