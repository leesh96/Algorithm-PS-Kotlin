package baekjoon.b1019

/*
플랫폼 : 백준
문제번호 : 1019
문제제목 : 책 페이지
난이도 : 골드 1
제한사항 : 2초/128MB
알고리즘 분류 : 수학

알고리즘 설명
1. 임의의 a를 설정하고 a와 n을 각각 일의 자리가 0, 일의 자리가 9인 수로 맞춘다.
2. 맞추는 과정에서 ++, --를 하는데 여기서는 완전탐색으로 등장 횟수를 더해준다.
3. 맞추고 나면 a ~ n까지 0-9는 (n / 10 - a / 10 + 1) * 10의 거듭제곱 번 등장한다.
4. 자릿수를 올려주고 같은 과정을 반복한다.

채점 결과 : 148ms/18468KB
풀이 날짜 : 2022/04/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var n = br.readLine().toInt()
    val counter = IntArray(10)
    var a = 1
    var count = 1

    while (a <= n) {
        while (n % 10 != 9 && a <= n) {
            add(n, counter, count)
            n--
        }

        while (a % 10 != 0 && a <= n) {
            add(a, counter, count)
            a++
        }

        if (a > n) break

        a /= 10
        n /= 10

        for (i in 0 until 10) {
            counter[i] += (n - a + 1) * count
        }

        count *= 10
    }

    bw.write(counter.joinToString(" "))
    bw.close()
    br.close()
}

private fun add(num: Int, counter: IntArray, count: Int) {
    var n = num
    while (n > 0) {
        counter[n % 10] += count
        n /= 10
    }
}