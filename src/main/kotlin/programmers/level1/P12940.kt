package programmers.level1

// 최대공약수와 최소공배수

class P12940 {
    fun solution(n: Int, m: Int): IntArray {
        val gcd = gcd(n, m)
        val lcm = n * m / gcd
        return intArrayOf(gcd, lcm)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (a % b == 0) b
        else gcd(b, a % b)
    }
}