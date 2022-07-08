package baekjoon.b15824

/*
플랫폼 : 백준
문제번호 : 15824
문제제목 : 너 봄에는 캡사이신이 맛있단다
난이도 : 골드 2
제한사항 : 1초/512MB
알고리즘 분류 : 수학, 정렬, 조합론, 분할 정복을 이용한 거듭제곱

알고리즘 설명
입력 배열의 크기가 최대 300,000으로 크다.
배열의 모든 조합의 최댓값과 최솟값의 차이의 합을 구해야 한다.

정렬된 배열 [a1, a2, ..., an]이 존재한다고 가정하자.
최댓값이 an, 최솟값이 a1인 조합의 갯수는 [a2, ..., an-1]의 부분 집합의 갯수 -> 2^(n-1)
따라서 최댓값이 an, 최솟값이 a1인 모든 조합의 그 차이의 합은 (an - a1) * 2^(n-1)이다.
그럼 최솟값 i(0..n-2), 최댓값을 (i+1..n-1)로 설정하고 위 식을 계산해서 합을 구해도 된다. -> O(n^2) 시간 초과

구하려는 값이 모든 조합의 최대값과 최소값의 합이므로 다시 말하면 모든 조합의 최댓값의 합과 모든 조합의 최솟값의 합의 차이이다.
a1이 최솟값인 조합의 갯수는 [a2, ..., an]의 부분 잡합의 갯수 -> 2^(n-1)
a1이 최댓값인 조합의 갯수는 []의 부분 집합의 갯수
...
따라서 수식으로 나타내면 i=[1..n]에 대해서 ai * (2^i - 2^(n- i))의 합이 된다.
2의 거듭제곱을 미리 구해두고 식을 계산하자.
2의 거듭제곱은 분할 정복을 이용한 거듭제곱을 구하는 알고리즘으로 개선 가능하다.

채점 결과 : 1328ms/86100KB
풀이 날짜 : 2022/07/08
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MOD = 1_000_000_007

fun main() {
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map(String::toLong).sorted()

    val power = LongArray(n + 1)
    power[0] = 1
    for (i in 1..n) {
        power[i] = (power[i-1] * 2) % MOD
    }

    var answer = 0L
    for (i in 0 until n) {
        answer = (answer + list[i] * (power[i] - power[n - 1 - i])) % MOD
    }

    bw.write("$answer")
    bw.close()
    br.close()
}
