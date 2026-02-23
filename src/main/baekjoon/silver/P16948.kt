package main.baekjoon.silver

/**
 * BOJ 16948 - 데스 나이트
 * https://www.acmicpc.net/problem/16948
 *
 * 분류: BFS, 그래프 탐색
 */
fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val n = readLine()!!.toInt()
    val parts = readLine()!!.split(' ').map { it.toInt() }

    val deque = ArrayDeque<IntArray>()
    val visited = Array(n) { BooleanArray(n) }

    val dr = intArrayOf(-2, -2, 0, 0, 2, 2)
    val dc = intArrayOf(-1, 1, -2, 2, -1, 1)

    deque.add(intArrayOf(parts[0], parts[1], 0))
    visited[parts[0]][parts[1]] = true

    val r2 = parts[2]
    val c2 = parts[3]

    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()
        val r = current[0]
        val c = current[1]
        val dist = current[2]

        // 목적지 도착 확인
        if (r == r2 && c == c2) {
            sb.append(dist)
            break
        }

        // 6방향 탐색
        for (i in 0..5) {
            val nr = r + dr[i]
            val nc = c + dc[i]
            // 범위 안 && 방문한 적이 없으면
            if (nr in 0 ..< n && nc in 0 ..< n && !visited[nr][nc]) {
                visited[nr][nc] = true
                deque.add(intArrayOf(nr, nc, dist + 1))
            }
        }
    }

    // r 차이 홀수거나 짝수여도 도달하지 못했을 경우 -1
    if (sb.isEmpty()) sb.append(-1)
    print(sb)
}
