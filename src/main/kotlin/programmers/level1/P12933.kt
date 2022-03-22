package programmers.level1

// 정수 내림차순으로 배치하기

class P12933 {
    fun solution(n: Long) =
        n.toString().split("").sortedDescending().joinToString("").toLong()
}