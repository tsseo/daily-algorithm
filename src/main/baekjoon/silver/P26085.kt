package main.baekjoon.silver

/**
 * BOJ 26085 - 효구와 호규 (Easy)
 * https://www.acmicpc.net/problem/26085
 *
 * 분류: 수학
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }

    if (n * m % 2 == 1) {
        print(-1)
        return@with
    }


    val grid = Array(n) { readLine()!!.split(' ').map { it.toInt() } }
    var zeroCount = 0
    var hasAdjacentPair = false

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (grid[i][j] == 0) zeroCount += 1
            if (j + 1 < m && grid[i][j] == grid[i][j + 1]) hasAdjacentPair = true
            if (i + 1 < n && grid[i][j] == grid[i + 1][j]) hasAdjacentPair = true
        }
    }

    if (zeroCount % 2 == 1) {
        print(-1)
        return@with
    }
    if (!hasAdjacentPair) {
        print(-1)
        return@with
    }

    print(1)
}