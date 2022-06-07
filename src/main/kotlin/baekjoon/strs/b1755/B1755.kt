package baekjoon.strs.b1755

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1755
문제제목 : 숫자놀이
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 문자열, 정렬

알고리즘 설명
1. 숫자별로 문자열 변환표를 만들고
2. 리스트에 문자숫자 - 숫자로 넣고
3. 리스트 정렬
4. 10개씩 출력

채점 결과 : 128ms/20428KB
풀이 날짜 : 2022/06/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val m: Int
    val n: Int
    with(StringTokenizer(br.readLine())) {
        m = nextToken().toInt()
        n = nextToken().toInt()
    }

    val info = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val answer = mutableListOf<Pair<String, Int>>()
    for (i in m..n) {
        val cur = i.toString()
        val sb = StringBuilder()
        for (j in cur.indices) {
            sb.append(info[cur[j].digitToInt()])
            sb.append(" ")
        }

        answer.add(sb.toString() to i)
    }

    answer.sortBy { it.first }

    var count = 0
    for (p in answer) {
        count++
        bw.write("${p.second} ")
        if (count % 10 == 0) {
            bw.newLine()
        }
    }

    bw.close()
    br.close()
}