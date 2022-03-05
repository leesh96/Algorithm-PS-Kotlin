package programmers.level1

class P72410 {
    fun solution(newId: String): String {
        var answer: String = newId.lowercase()
        answer = answer.replace(regex = Regex("[^0-9a-z_.-]"), replacement = "")
        answer = answer.replace(regex = Regex("[.]{2,}"), replacement = ".")
        while (answer.isNotEmpty() && answer.first() == '.') answer = answer.removePrefix(".")
        while (answer.isNotEmpty() && answer.last() == '.') answer = answer.removeSuffix(".")
        if (answer.length >= 16) answer = answer.substring(0, 15)
        while (answer.isNotEmpty() && answer.last() == '.') answer = answer.removeSuffix(".")
        if (answer.isEmpty()) answer += "a"
        while (answer.length <= 2) {
            answer += answer.last()
        }
        return answer
    }
}