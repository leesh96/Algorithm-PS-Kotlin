package baekjoon.b1052

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1052
문제제목 : 물병
난이도 : 실버 1
제한사항 : 물병
알고리즘 분류 : 1초/512MB

알고리즘 설명
이진수로 변환했을 때 1의 개수를 찾는것 -> k개 이하여야 한다.
N부터 1씩 증가시키며 판단

채점 결과 : 1444ms/293012KB
풀이 날짜 : 2022/05/22
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = StringTokenizer(br.readLine())
    var n = input.nextToken().toInt()
    var k = input.nextToken().toInt()

    var answer = 0

    while (true) {
        val binary = n.toString(2)
        var count = 0

        for (i in binary.indices) {
            if (binary[i] == '1') count++
        }

        if (count <= k) {
            break
        }

        n++
        answer++
    }

    bw.write("$answer")
    bw.close()
    br.close()
}