package programmers.level1

// 핸드폰 번호 가리기

class P12948 {
    fun solution(phoneNumber: String): String {
        return phoneNumber.mapIndexed { index, c ->
            if (index in 0..phoneNumber.lastIndex - 4) '*' else c
        }.joinToString("")
    }
}