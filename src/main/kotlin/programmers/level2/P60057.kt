package programmers.level2

// 문자열 압축

class P60057 {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE

        for (step in 1..s.length) {
            val zipWords = s.chunked(step)

            var count = 1
            val sb = StringBuilder()
            for (i in 0 .. zipWords.lastIndex) {
                if (i == zipWords.lastIndex) {
                    if (count == 1) {
                        sb.append(zipWords[i])
                    } else {
                        sb.append("$count${zipWords[i]}")
                    }
                    break
                }

                if (zipWords[i] == zipWords[i+1]) {
                    count++
                } else {
                    if (count == 1) {
                        sb.append(zipWords[i])
                    } else {
                        sb.append("$count${zipWords[i]}")
                    }
                    count = 1
                }

            }

            answer = minOf(answer, sb.length)
        }

        return answer
    }
}