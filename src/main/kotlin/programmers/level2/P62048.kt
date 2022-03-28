package programmers.level2

// 멀쩡한 사각형

class P62048 {
    fun solution(w: Int, h: Int): Long {
        val wl = w.toLong()
        val hl = h.toLong()

        return (wl * hl) - (wl + hl) + gcd(wl, hl)
    }

    private fun gcd(x: Long, y: Long): Long {
        var mod = 0L
        var a = x
        var b = y

        while (b != 0L) {
            mod = a % b
            a = b
            b = mod
        }

        return a
    }
}