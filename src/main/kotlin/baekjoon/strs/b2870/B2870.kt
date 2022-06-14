package baekjoon.strs.b2870

/*
플랫폼 : 백준
문제번호 : 2870
문제제목 : 수학숙제
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 정렬, 파싱

알고리즘 설명
1. 문자열을 탐색하면서 숫자 문자를 만나면 이어 붙여준다.
2. 알파벳을 만나면 앞의 0을 자르기 위해 만들어진 숫자 문자열을 파싱한다.
3. 파싱된 숫자 문자열을 리스트에 넣어줌
4. 정렬 -> 길이순으로, 길이가 같으면 문자열 비교

채점 결과 : 288ms/27188kB
풀이 날짜 : 2022/06/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val numbers = mutableListOf<String>()

    repeat(n) {
        val input = br.readLine()
        var number = ""
        for (c in input) {
            if (c.isDigit()) {
                number = "$number$c"
            } else {
                if (number != "") {
                    numbers.add(parseNumber(number))
                    number = ""
                }
            }
        }

        if (number != "") {
            numbers.add(parseNumber(number))
        }
    }

    numbers.sortWith { o1, o2 -> if (o1.length == o2.length) o1.compareTo(o2) else o1.length - o2.length }

    bw.write(numbers.joinToString("\n"))
    bw.close()
    br.close()
}

private fun parseNumber(numstr: String): String {
    var idx = 0
    while (idx in numstr.indices) {
        if (numstr[idx].digitToInt() != 0) {
            break
        }
        idx++
    }

    return if (idx > numstr.lastIndex) "0" else numstr.substring(idx)
}