package main.baekjoon.bronze

import kotlin.math.roundToInt

/**
 * BOJ 3448 - 문자 인식 인식률
 * https://www.acmicpc.net/problem/3448
 *
 * 분류: 문자열, 구현
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val n = readLine()!!.trim().toInt()
    for (i in 0..<n) {

        var x = 0
        var o = 0

        while (true) {
            val line = readLine() ?: ""
            if (line.isEmpty()) {
                // 인식률 = 인식한 문자(o) / 전체 문자(x+o) * 100
                val per = o.toDouble() / (x + o) * 100
                // 소수점 둘째 자리에서 반올림, 정수면 정수만 출력
                val rounded = (per * 10).roundToInt() / 10.0
                val formatted = if (rounded == rounded.toLong().toDouble()) {
                    "${rounded.toLong()}"
                } else {
                    "%.1f".format(rounded)
                }
                sb.appendLine("Efficiency ratio is $formatted%.")
                break
            }

            line.forEach {
                if (it == '#') {
                    x++
                } else {
                    o++
                }
            }
        }

    }

    print(sb.trimEnd())
}
