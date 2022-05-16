package baekjoon.b2304

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2304
문제제목 : 창고 다각형
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 자료 구조, 브루트포스 알고리즘, 스택

알고리즘 설명
1. 기둥을 x위치에 따라 정렬
2. 왼쪽부터 오른쪽으로(정방향) 기둥의 높이들을 보면서 증가하는 높이를 만나면 이전 지붕까지의 넓이 계산
3. 최대 높이의 기둥을 찾는다.
4. 역방향으로 기둥의 높이들을 보면서 최대 높이까지 2번을 반복
5. 마지막으로 최대 기둥의 넓이(=높이)를 더해준다.
point. 최대 높이의 기동과 높이가 같은 기둥도 넓이 계산을 해줘야 놓치는 기둥이 없다.

채점 결과 : 148ms/15080KB
풀이 날짜 : 2022/05/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val pillar = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            pillar.add(nextToken().toInt() to nextToken().toInt())
        }
    }
    pillar.sortBy { it.first }

    var size = 0
    var maxIdx = 0
    var leftMax = pillar[0]
    for (i in 1 until n) {
        if (leftMax.second <= pillar[i].second) {
            size += (pillar[i].first - leftMax.first) * leftMax.second
            leftMax = pillar[i]
            maxIdx = i
        }
    }

    var rightMax = pillar[n-1]
    for (i in n - 2 downTo maxIdx) {
        if (rightMax.second <= pillar[i].second) {
            size += (rightMax.first - pillar[i].first) * rightMax.second
            rightMax = pillar[i]
        }
    }

    size += rightMax.second
    bw.write("$size")
    bw.close()
    br.close()
}