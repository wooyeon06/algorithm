package bfs;

import java.util.*;

public class MazeSolver {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 0}; // 시작점
        int[] end = {4, 4};   // 목표점

        int shortestPath = bfsMaze(maze, start, end);
        System.out.println("최단 경로 길이: " + shortestPath); // 출력: 최단 경로 길이: 8
    }

    public static int bfsMaze(int[][] maze, int[] start, int[] end) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.add(new int[] {start[0], start[1], 0}); // {x, y, 거리}
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 목표 지점 도달
            if (x == end[0] && y == end[1]) {
                return distance;
            }

            // 상하좌우 탐색
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny] && maze[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1; // 경로가 없는 경우
    }
}
