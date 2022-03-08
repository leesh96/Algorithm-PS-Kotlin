package programmers.level1

// 체육복

class P42862 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        lost.sort()
        reserve.sort()
        val lostStd = lost.toMutableSet()
        val reserveStd = reserve.toMutableSet()

        reserve.filter { it in lost }.forEach { lostStd.remove(it); reserveStd.remove(it) }
        reserveStd.forEach {
            when {
                it - 1 in lostStd -> lostStd.remove(it - 1)
                it + 1 in lostStd -> lostStd.remove(it + 1)
            }
        }
        return n - lostStd.count()
    }
}