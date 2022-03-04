package programmers.level1

import java.util.*

class P92334 {
    fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportList = report.distinct().map {
            with(StringTokenizer(it)) {
                Report(nextToken(), nextToken())
            }
        }

        val vanCount = reportList.groupBy { it.to }
            .filter { it.value.size >= k }
            .map { it.key }

        val mail = reportList.groupBy { it.from }
            .mapValues { entry ->
                entry.value.map { it.to }.count { id ->
                    vanCount.contains(id)
                }
            }

        return idList.map { id -> mail[id] ?: 0 }.toIntArray()
    }

    data class Report(val from: String, val to: String)
}