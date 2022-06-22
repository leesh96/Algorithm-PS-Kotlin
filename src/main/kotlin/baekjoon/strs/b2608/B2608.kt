package baekjoon.strs.b2608

/*
플랫폼 : 백준
문제번호 : 2608
문제제목 : 로마 숫자
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 문자열

알고리즘 설명
1. Map에 로마 숫자 변환 맵핑을 한다. 이 때 4, 9에 대한 것도 만들어준다.
2. 문자열 파싱해서 숫자로 만들고
3. 숫자를 로마자로 파싱 -> Map을 value로 내림차순 정렬하고 몫과 나머지를 사용

채점 결과 : 176ms/25888KB
풀이 날짜 : 2022/06/22
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = br.readLine()
    val b = br.readLine()
    val map = mutableMapOf<String, Int>().apply {
        put("I", 1)
        put("IV", 4)
        put("V", 5)
        put("IX", 9)
        put("X", 10)
        put("XL", 40)
        put("L", 50)
        put("XC", 90)
        put("C", 100)
        put("CD", 400)
        put("D", 500)
        put("CM", 900)
        put("M", 1000)
    }

    val an = romanToNum(a, map)
    val bn = romanToNum(b, map)
    val sum = an + bn
    val answer = numToRoman(sum, map)

    bw.write("$sum")
    bw.newLine()
    bw.write(answer)
    bw.close()
    br.close()
}

private fun romanToNum(r: String, table: MutableMap<String, Int>): Int {
    var value = 0
    var i = 0
    while (i in r.indices) {
        val cur = r[i]
        if ((cur == 'I' || cur == 'X' || cur == 'C') && i < r.lastIndex) {
            val key = "$cur${r[i+1]}"
            if (table.containsKey(key)) {
                value += table.getValue(key)
                i += 2
                continue
            }
        }
        value += table.getValue("$cur")
        i++
    }

    return value
}

private fun numToRoman(n: Int, table: MutableMap<String, Int>): String {
    val sb = StringBuilder()
    val sortedTable = table.entries.toList().sortedByDescending { it.value }

    var num = n
    while (num != 0) {
        for ((k, v) in sortedTable) {
            val div = num / v
            if (div != 0) {
                repeat(div) {
                    sb.append(k)
                }
                num %= v
                break
            }
        }
    }

    return sb.toString()
}