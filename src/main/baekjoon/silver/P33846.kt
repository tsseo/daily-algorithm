package main.baekjoon.silver

/**
 * BOJ 33846 - 삽입 정렬
 * https://www.acmicpc.net/problem/33846
 *
 * 분류: 정렬, 구현
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val (n, t) = readLine()!!.trim().split(" ").map { it.toInt() }
    val a = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()

    val front = a.copyOfRange(0, t)
    front.sort()

    for (v in front) sb.append(v).append(' ')
    for (i in t ..<n ) sb.append(a[i]).append(' ')

    print(sb.trimEnd())
}
