package programmers.level1

// 내적

class P70128 {
    fun solution(a: IntArray, b: IntArray) =
        a.zip(b) { aNum, bNum -> aNum * bNum }.sum()
}