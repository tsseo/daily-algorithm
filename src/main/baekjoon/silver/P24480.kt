package main.baekjoon.silver

/**
 * BOJ 24480 - 알고리즘 수업 - 깊이 우선 탐색 2
 * https://www.acmicpc.net/problem/24480
 *
 * 분류: DFS, 그래프 탐색, 정렬
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val (n, m, r) = readLine()!!.split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (u, v) = readLine()!!.split(' ').map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    graph.forEach { it.sortDescending() }

    val order = IntArray(n + 1)   // 방문 순서 (기본값 0 = 미방문)
    var count = 0                       // 방문 카운터

    fun dfs(node: Int) {
        order[node] = ++count           // 방문 순서 기록
        for (next in graph[node]) {     // 인접 노드 순회 (내림차순 정렬됨)
            if (order[next] == 0) {     // 미방문이면
                dfs(next)
            }
        }
    }

    dfs(r) // 시작 정점에서 출발

    for (i in 1..n) {
        sb.appendLine(order[i])
    }

    print(sb)
}
