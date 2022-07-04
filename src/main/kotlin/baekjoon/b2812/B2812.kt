package baekjoon.b2812

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2812
문제제목 : 크게 만들기
난이도 : 골드 3
제한사항 : 1초/128MB
알고리즘 분류 : 자료 구조, 그리디, 스택

알고리즘 설명
1. 리스트에 숫자를 담는다.
2. 담을 때 가장 마지막에 추가한 숫자 = 마지막 숫자와 크기를 비교해서, 마지막 숫자가 집어넣을 숫자보다 작다면 지워준다.
3. 왜? 먼저 넣은 숫자가 앞으로 가기 때문에 작은 수가 들어가지면 전체 숫자가 작아진다.
4. 모든 숫자를 다 확인했다면 지울 수 있는 숫자가 남아있을 수 있기 때문에 k만큼 뒤에서부터 빼고 출력해준다.

채점 결과 : 412ms/34516KB
풀이 날짜 : 2022/07/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    
    val input = br.readLine()
    val numbers = mutableListOf<Char>()
    for (c in input) {
        while (k > 0 && numbers.isNotEmpty() && numbers.last() < c) {
            numbers.removeLast()
            k -= 1
        }
        numbers.add(c)
    }

    bw.write(numbers.dropLast(k).joinToString(""))
    bw.close()
    br.close()
}