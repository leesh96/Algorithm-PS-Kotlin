package baekjoon.b13335

import java.util.*

/*
플랫폼 : 백준
문제번호 : 13335
문제제목 : 트럭
난이도 : 실버 1
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 자료 구조, 시뮬레이션, 큐

알고리즘 설명
1. 트럭을 큐에 넣고
2. 다리 위의 트럭도 큐로 받는다.
3. 다리 위의 단위 길이에 트럭이 없는 것을 0으로 표현
4. 트럭이 레디큐에서 나올 때는 다리의 최대 하중을 넘어가면 안된다. -> 이 때도 큐에는 0을 넣는다.
5. 매 시간마다 반복

채점 결과 : 112ms/13604KB
풀이 날짜 : 2022/05/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val w: Int
    val l: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        w = nextToken().toInt()
        l = nextToken().toInt()
    }

    val truckReady = LinkedList<Int>()
    with(StringTokenizer(br.readLine())) {
        repeat(n) {
            truckReady.offer(nextToken().toInt())
        }
    }

    var time = 0
    var bridge = 0
    val truckBridge = LinkedList<Int>().apply {
        repeat(w) {
            offer(0)
        }
    }

    while (truckBridge.isNotEmpty()) {
        time++
        bridge -= truckBridge.poll()
        if (truckReady.isNotEmpty()) {
            if (truckReady.peek() + bridge <= l) {
                truckBridge.offer(truckReady.poll().also { bridge += it })
            } else {
                truckBridge.offer(0)
            }
        }
    }

    bw.write("$time")
    bw.close()
    br.close()
}