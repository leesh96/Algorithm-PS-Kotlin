package baekjoon.b1138

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1138
문제제목 : 한 줄로 서기
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
자신보다 왼쪽에 자신보다 큰 키의 사람수 = 해석하면 삽입될 순서(인덱스)이다.
마지막 사람의 왼쪽에는 항상 0명의 사람이 오기 때문에 입력을 거꾸로 보면서 리스트에 삽입한다.

채점 결과 : 132ms/21048KB
풀이 날짜 : 2022/04/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val heights = with(StringTokenizer(br.readLine())) {
        IntArray(n) { nextToken().toInt() }
    }

    val answer = mutableListOf<Int>()
    for (i in n - 1 downTo 0) {
        answer.add(heights[i], i + 1)
    }

    bw.write(answer.joinToString(" "))
    bw.close()
    br.close()
}