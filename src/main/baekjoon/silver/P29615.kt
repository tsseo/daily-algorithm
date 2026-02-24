package main.baekjoon.silver

/**
 * BOJ 29615 - 알파빌과 베타빌
 * https://www.acmicpc.net/problem/29615
 *
 * 분류: 그리디, 정렬
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val nm = readLine()!!.split(' ').map { it.toInt() }
    val people = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val friends = readLine()!!.split(' ').map { it.toInt() }

    val count = people.take(nm[1]).count { it !in friends }

    print(count)
}
