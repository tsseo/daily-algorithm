package main.baekjoon.bronze

/**
 * BOJ 2163 - 초콜릿 자르기
 * https://www.acmicpc.net/problem/2163
 *
 * 분류: 수학
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    print(n * m - 1)
}
