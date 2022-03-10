package programmers.level1

// 2016년

class P12901 {
    fun solution(a: Int, b: Int): String {
        val dayOfMonth = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val day = arrayOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")

        var date = 0
        for (i in 1 until a) {
            date += dayOfMonth[i-1]
        }
        date += b

        return day[date % 7]
    }
}