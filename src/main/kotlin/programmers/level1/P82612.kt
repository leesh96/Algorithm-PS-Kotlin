package programmers.level1

// 부족한 금액 계산하기

class P82612 {
    fun solution(price: Int, money: Int, count: Int): Long =
        (1..count.toLong()).sumOf { it * price }.let {
            if (it <= money) 0 else it - money
        }
}