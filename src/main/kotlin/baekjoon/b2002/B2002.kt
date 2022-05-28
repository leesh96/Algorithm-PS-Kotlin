package baekjoon.b2002

/*
플랫폼 : 백준
문제번호 : 2002
문제제목 : 추월
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 자료 구조, 문자열, 해시를 사용한 집합과 맵

알고리즘 설명
1. 차가 들어간 정보(차량번호 - 순서)를 Map에 저장
2. 차가 나온 정보를 입력받으면서 나온 차량이 들어간 순서를 배열에 저장
3. 배열을 돌면서 들어갈 때 자신보다 앞서 있던 차(배열에 저장된 순서 값)보다 먼저 나갔으면 추월을 한 것임

채점 결과 : 108ms/12976KB
풀이 날짜 : 2022/05/28
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val carIn = mutableMapOf<String, Int>()
    repeat(n) {
        carIn[br.readLine()] = it
    }

    val carOut = IntArray(n)
    for (i in 0 until n) {
        val carNum = br.readLine()
        carOut[i] = carIn[carNum]!!
    }

    var answer = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (carOut[i] > carOut[j])  {
                answer++
                break
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}