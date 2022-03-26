package programmers.level2

// 오픈채팅방

class P42888 {
    fun solution(record: Array<String>): Array<String> {
        val map = mutableMapOf<String, String>()
        val answer = mutableListOf<Pair<String, String>>()

        record.map { it.split(" ") }.forEach {
           when (it[0]) {
               "Enter" -> {
                   answer.add(it[0] to it[1])
                   map[it[1]] = it[2]
               }
               "Leave" -> {
                   answer.add(it[0] to it[1])
               }
               else -> {
                   map[it[1]] = it[2]
               }
           }
        }

        return answer.map { (type, id) ->
            if (type == "Enter") "${map[id]}님이 들어왔습니다."
            else "${map[id]}님이 나갔습니다."
        }.toTypedArray()
    }
}