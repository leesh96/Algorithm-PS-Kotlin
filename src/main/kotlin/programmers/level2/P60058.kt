package programmers.level2

// 괄호 변환

class P60058 {
    fun solution(p: String): String {
        if (p.isEmpty()) return ""

        var answer = ""
        val sliceIdx = findBalanceStringIdx(p)
        val u = p.substring(0, sliceIdx+1)
        val v = p.substring(sliceIdx + 1)

        if (checkString(u)) {
            answer = "$u${solution(v)}"
        } else {
            val nextU = u.drop(1).dropLast(1).map { if (it == '(') ')' else '(' }
            answer = "(${solution(v)})${nextU.joinToString("")}"
        }

        return answer
    }

    private fun findBalanceStringIdx(p: String): Int {
        var count = 0

        for ((idx, ch) in p.withIndex()) {
            if (ch == '(') count++
            else count--

            if (count == 0) return idx
        }

        return p.lastIndex
    }

    private fun checkString(p: String): Boolean {
        var count = 0

        for (ch in p) {
            if (ch == '(') count++
            else {
                if (count == 0) return false
                count--
            }
        }

        return true
    }
}