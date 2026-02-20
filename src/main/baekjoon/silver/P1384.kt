package main.baekjoon.silver

/**
 * BOJ 1384 - 메시지
 * https://www.acmicpc.net/problem/1384
 *
 * 분류: 구현, 시뮬레이션
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    var group = 1
    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        // n 줄 읽어서 이름 배열 + 메시지 배열 세팅
        val names = mutableListOf<String>()
        val messages = mutableListOf<List<String>>()
        for (i in 0..<n) {
            val parts = readLine()!!.split(" ")
            names.add(parts[0])
            messages.add(parts.drop(1))
        }

        // N 찾기
        sb.appendLine("Group $group")
        var hasNasty = false

        for (i in 0..<n) {
            for (j in messages[i].indices) {
                if (messages[i][j] == "N") {
                    val writer = names[(i - 1 - j + n) % n]
                    sb.appendLine("$writer was nasty about ${names[i]}")
                    hasNasty = true
                }
            }
        }

        if (!hasNasty) sb.appendLine("Nobody was nasty")
        sb.appendLine()
        group++
    }

    print(sb)
}
