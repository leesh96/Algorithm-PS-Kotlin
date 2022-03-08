package programmers.level1

// K번째수

class P42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size)
        commands.forEachIndexed { index, command ->
            val (from, to, idx) = command
            answer[index] = array.sliceArray(from-1 until to).sortedArray()[idx-1]
        }
        return answer
    }
}