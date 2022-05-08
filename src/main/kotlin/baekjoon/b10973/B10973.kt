package baekjoon.b10973

import java.util.*

/*
플랫폼 : 백준
문제번호 : 10973
문제제목 : 이전 순열
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 구현, 조합론

알고리즘 설명
순열의 뒤부터 arr[i-1] < arr[i]를 만족하는 가장 큰 i를 찾는다.
순열의 뒤부터 j >= 1이고 a[j] > a[i-1]을 만족하는 가장 큰 j를 찾는다.
a[i-1]과 a[j]를 서로 바꾸고 i부터 j-1까지 순열을 뒤집는다.

채점 결과 : 180ms/20184KB
풀이 날짜 : 2022/05/08
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    var flag = true
    var i = arr.lastIndex
    while (i > 0 && arr[i-1] <= arr[i]) i--
    if (i <= 0) flag = false

    if (flag) {
        var j = arr.lastIndex
        while (arr[j] >= arr[i-1]) j--
        arr[j] = arr[i-1].also { arr[i-1] = arr[j] }
        j = arr.lastIndex

        while (i < j) {
            arr[i] = arr[j].also { arr[j] = arr[i] }
            i++
            j--
        }

        bw.write(arr.joinToString(" "))
    } else {
        bw.write("-1")
    }

    bw.close()
    br.close()
}