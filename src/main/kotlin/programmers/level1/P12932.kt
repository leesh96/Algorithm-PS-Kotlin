package programmers.level1

// 자연수 뒤집어 배열로 만들기

class P12932 {
    fun solution(n: Long) =
        n.toString().reversed().map { it.digitToInt() }.toIntArray()
}