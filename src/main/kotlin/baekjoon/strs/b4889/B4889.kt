package baekjoon.strs.b4889

/*
플랫폼 : 백준
문제번호 : 4889
문제제목 : 안정적인 문자열
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 자료 구조, 문자열, 그리디, 스택

알고리즘 설명
1. 여는 괄호를 기준으로 생각
2. 여는 괄호를 만나면 무조건 여는 괄호 카운터 1 증가
3. 닫는 괄호를 만나면 케이스가 2개
3-1 만약 여는 괄호가 지금까지 1개도 없음 -> 닫는 괄호를 여는 괄호로 바꾸는 연산 1회, 여는 괄호 카운터 1 증가
3-2 여는 괄호가 존재 -> 여는 괄호 카운터 1 감소
4. 마지막으로 여는 괄호가 남아있으면 닫는 괄호로 바꾸는 연산을 추가 한다. 이는 여는 괄호의 수 / 2 -> 입력이 짝수개이기 때문

채점 결과 : 124ms/14328KB
풀이 날짜 : 2022/06/08
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var t = 1
    while (true) {
        val input = br.readLine()

        if (input.contains("-")) {
            break
        }

        var openCount = 0
        var answer = 0
        for (c in input) {
            if (c == '{') {
                openCount++
            } else if (c == '}') {
                if (openCount == 0) {
                    openCount++
                    answer++
                } else {
                    openCount--
                }
            }
        }

        bw.write("$t. ${answer + openCount / 2}")
        bw.newLine()

        t++
    }

    bw.close()
    br.close()
}