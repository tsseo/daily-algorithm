package main.baekjoon.bronze

/**
 * BOJ 20124 - 모르고리즘 회장님 추천 받습니다
 * https://www.acmicpc.net/problem/20124
 *
 * 분류: 정렬, 구현
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()

    var maxScore = 0
    var maxName = ""

    repeat(n) {
        val (name, score) = readLine()!!.split(' ')
        val s = score.toInt()
        if (s > maxScore || (s == maxScore && name < maxName)) { // 문자열 비교: Java의 compareTo() 없이 < 로 사전순 비교 가능
            maxScore = s
            maxName = name
        }
    }

    print(maxName)
}
