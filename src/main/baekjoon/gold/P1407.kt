package main.baekjoon.gold

/**
 * BOJ 1407 - 2로 몇 번 나누어질까
 * https://www.acmicpc.net/problem/1407
 *
 * 분류: 수학
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val (a, b) = readLine()!!.trim().split(' ').map { it.toLong() }

    print(g(b) - g(a - 1))
}

// 1~N까지 f(1)+f(2)+...+f(N) 합
fun g(n: Long): Long {
    var sum = 0L
    var pow = 1L  // 2^k

    while (pow <= n) {
        sum += pow * (n / pow - n / (pow * 2))
        pow *= 2
    }

    return sum
}
