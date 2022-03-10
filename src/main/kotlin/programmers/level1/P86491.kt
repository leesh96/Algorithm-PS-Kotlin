package programmers.level1

// 최소직사각형

import kotlin.math.max
import kotlin.math.min

class P86491 {
    fun solution(sizes: Array<IntArray>): Int {
        var width = Int.MIN_VALUE
        var height = Int.MIN_VALUE
        for ((w, h) in sizes) {
            width = max(width, max(w, h))
            height = max(height, min(w, h))
        }
        return width * height
    }
}