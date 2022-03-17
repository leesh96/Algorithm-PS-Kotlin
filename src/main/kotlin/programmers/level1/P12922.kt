package programmers.level1

// 수박수박수박수박수박수?

class P12922 {
    fun solution(n: Int): String {
        val answer = CharArray(n) {
            if (it % 2 == 0) '수' else '박'
        }
        return answer.concatToString()
    }
}