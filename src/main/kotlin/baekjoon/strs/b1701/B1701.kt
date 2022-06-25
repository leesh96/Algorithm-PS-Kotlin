package baekjoon.strs.b1701

/*
플랫폼 : 백준
문제번호 : 1701
문제제목 : Cubeditor
난이도 : 골드 3
제한사항 : 0.5초/128MB
알고리즘 분류 : 문자열, KMP

알고리즘 설명
1. KMP 알고리즘에서 부분 일치 테이블 원리를 사용
2. 두 번이상 등장하는 가장 긴 부분 문자열 길이 = 부분 일치 테이블에서 가장 큰 값
3. 문자열의 길이를 1씩 줄이면서(모든 부분 문자열에 대해서) 부분 일치 테이블을 만들고 max 값 갱신

채점 결과 : 304ms/87412KB
풀이 날짜 : 2022/06/25
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val str = br.readLine()

    var answer = 0
    for (i in str.indices) {
        val pattern = str.substring(i)
        val m = pattern.length
        val table = IntArray(m)

        var match = 0
        for (begin in 1 until m) {
            while (match > 0 && pattern[begin] != pattern[match]) {
                match = table[match - 1]
            }

            if (pattern[begin] == pattern[match]) {
                match += 1
                table[begin] = match
                answer = maxOf(answer, match)
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}