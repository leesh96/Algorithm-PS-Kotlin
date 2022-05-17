package baekjoon.b1747

import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 1747
문제제목 : 소수&팰린드롬
난이도 : 실버 1
제한사항 : 2초/256MB
알고리즘 분류 : 수학, 브루트포스 알고리즘, 정수론, 소수 판정, 에라토스테네스의 체

알고리즘 설명
1. 소수 판별은 에라토스테네스의 체 원리 사용
2. 팰린드롬은 문자열 변환 후 체크
유의: 1은 소수가 아님에 유의

채점 결과 : 496ms/18304KB
풀이 날짜 : 2022/05/17
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var n = br.readLine().toInt()
    if (n == 1) {
        bw.write("2")
    } else {
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                bw.write("$n")
                break
            }
            n++
        }
    }

    bw.close()
    br.close()
}

private fun isPrime(n: Int): Boolean {
    var mod = 2
    while (mod <= sqrt(n.toDouble())) {
        if (n % mod == 0) return false
        mod++
    }
    return true
}

private fun isPalindrome(n: Int): Boolean {
    val itos = n.toString()
    for (i in 0..itos.length / 2) {
        if (itos[i] != itos[itos.lastIndex - i]) {
            return false
        }
    }
    return true
}