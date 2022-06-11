package baekjoon.strs.b13413

/*
플랫폼 : 백준
문제번호 : 13413
문제제목 : 오셀로 재배치
난이도 : 실버 4
제한사항 : 2초/256MB
알고리즘 분류 : 문자열, 그리디

알고리즘 설명
1. 기존 오셀로와 목표 오셀로를 비교하면서 다른 색을 각각 카운트
2. 결국 개수가 같을 때까지는 자리 바꾸기로 만들 수 있다. 그리고 남는 모양은 바꾸는 연산을 해야함
3. 두 카운트 값의 최댓값이 최소 연산 횟수

채점 결과 : 352ms/90900KB
풀이 날짜 : 2022/06/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val exist = br.readLine()
        val target = br.readLine()

        var wCount = 0
        var bCount = 0
        for (i in 0 until n) {
            if (exist[i] != target[i]) {
                if (exist[i] == 'W') wCount++
                else bCount++
            }
        }

        bw.write("${maxOf(wCount, bCount)}")
        bw.newLine()
    }

    bw.close()
    br.close()
}