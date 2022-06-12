package baekjoon.strs.b9536

/*
플랫폼 : 백준
문제번호 : 9536
문제제목 : 여우는 어떻게 울지?
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 파싱

알고리즘 설명
1. 집합에 동물 울음소리 넣고
2. 입력에서 필터링

채점 결과 : 140ms/20780KB
풀이 날짜 : 2022/06/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val t = br.readLine().toInt()
    repeat(t) {
        val input = br.readLine().split(" ")
        val sounds = mutableSetOf<String>()

        while (true) {
            val info = br.readLine()
            if (info == "what does the fox say?") break

            val animal = info.split(" ")
            sounds.add(animal[2])
        }

        bw.write(input.filter { !sounds.contains(it) }.joinToString(" "))
        bw.newLine()
    }

    bw.close()
    br.close()
}