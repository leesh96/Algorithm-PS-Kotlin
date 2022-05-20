package baekjoon.b2810

/*
플랫폼 : 백준
문제번호 : 2810
문제제목 : 컵홀더
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열, 그리디

알고리즘 설명
1인석이면 컵홀더 추가만
커플석이면 인덱스도 하나 옮겨주기

채점 결과 : 88ms/12276KB
풀이 날짜 : 2022/05/20
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val seat = br.readLine()

    var count = 1
    var i = 0
    while (i < n) {
        val cur = seat[i]
        if (cur == 'S') count++
        else if (cur == 'L') {
            i++
            count++
        }
        i++
    }
    bw.write("${if (count > n) n else count}")
    bw.close()
    br.close()
}