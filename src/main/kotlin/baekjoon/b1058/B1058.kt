package baekjoon.b1058

/*
플랫폼 : 백준
문제번호 : 1058
문제제목 : 친구
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 플로이드-와샬, 브루트포스 알고리즘

알고리즘 설명
2-친구: 서로 친구이거나 한 다리 건너 아는 사이인 경우
친구 관계를 1, 자기 자신은 0, 친구가 아닌 관계는 임의의 큰 수로 설정하고 플로이드-와샬 수행
결과가 2이하인 관계를 카운트한다.

채점 결과 : 100ms/12628KB
풀이 날짜 : 2022/05/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val INF = 100_000

fun main() {
    val n = br.readLine().toInt()
    val connection = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until n) {
            when {
                i == j -> connection[i][j] = 0
                input[j] == 'Y' -> connection[i][j] = 1
                input[j] == 'N' -> connection[i][j] = INF
            }
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == k || k == j || i == j) continue
                if (connection[i][j] > connection[i][k] + connection[k][j]) connection[i][j] = connection[i][k] + connection[k][j]
            }
        }
    }

    var answer = Int.MIN_VALUE
    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (i == j) continue
            if (connection[i][j] <= 2) count++
        }
        answer = maxOf(answer, count)
    }


    bw.write("$answer")
    bw.close()
    br.close()
}