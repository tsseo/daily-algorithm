package main.baekjoon.silver

/**
 * BOJ 14940 - 쉬운 최단거리
 * https://www.acmicpc.net/problem/14940
 *
 * 분류: BFS, 그래프 탐색
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val (n, m) = readLine()!!.split(' ').map { it.toInt() }

    // 격자 입력, 거리 배열 -1로 초기화 (미방문 = -1)
    val grid = Array(n) { readLine()!!.split(' ').map { it.toInt() } }
    val dist = Array(n) { IntArray(m) { -1 } }

    // 상하좌우 방향
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    // 목표지점(2) 찾기 + 벽(0)은 거리 0으로 설정
    var startX = 0
    var startY = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (grid[i][j] == 2) { startX = i; startY = j }
            if (grid[i][j] == 0) dist[i][j] = 0
        }
    }

    // BFS: 목표지점에서 시작하여 거리 계산
    val queue: ArrayDeque<IntArray> = ArrayDeque()
    queue.add(intArrayOf(startX, startY))
    dist[startX][startY] = 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx !in 0..<n || ny !in 0..<m) continue  // 범위 밖
            if (dist[nx][ny] != -1) continue              // 이미 방문 or 벽
            dist[nx][ny] = dist[x][y] + 1
            queue.add(intArrayOf(nx, ny))
        }
    }

    // 출력: 도달 못한 곳은 -1 그대로 출력됨
    for (i in 0..<n) {
        sb.appendLine(dist[i].joinToString(" "))
    }

    print(sb)
}
