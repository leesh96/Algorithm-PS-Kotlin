package baekjoon.b11689

/*
플랫폼 : 백준
문제번호 : 11689
문제제목 : GCD(n, k) = 1
난이도 : 골드 1
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 정수론, 오일러 피 함수

알고리즘 설명
오일러 파이 함수
https://loosie.tistory.com/724

채점 결과 : 100ms/12364KB
풀이 날짜 : 2022/04/28
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var n = br.readLine().toLong()
    var pi = n
    var i = 2L
    while (i * i <= n) {
        if (n % i == 0L) {
            pi = pi / i * (i - 1)
        }

        while (n % i == 0L) {
            n /= i
        }

        i++
    }

    if (n != 1L) {
        pi = pi / n * (n - 1)
    }

    bw.write("$pi")
    bw.close()
    br.close()
}