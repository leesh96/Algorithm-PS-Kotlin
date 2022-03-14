package programmers.level1

// 두 정수 사이의 합

class P12912 {
    fun solution(a: Int, b: Int) =
        if (a <= b) (a.toLong()..b).sum() else (b.toLong()..a).sum()
}