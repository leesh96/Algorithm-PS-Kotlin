package programmers.level1

// 서울에서 김서방 찾기

class P12919 {
    fun solution(seoul: Array<String>) = "김서방은 ${seoul.indexOfFirst { it == "Kim" }}에 있다"
}