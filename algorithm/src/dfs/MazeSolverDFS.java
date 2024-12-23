package dfs;

public class MazeSolverDFS {
    private static final int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean found = false;

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, visited, 0, 0, 4, 4);
        System.out.println("경로를 찾았는가? " + found); // 출력: 경로를 찾았는가? true
    }

    public static void dfs(int[][] maze, boolean[][] visited, int x, int y, int endX, int endY) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || visited[x][y] || maze[x][y] == 1) {
            return;
        }

        // 목표 지점 도달
        if (x == endX && y == endY) {
            found = true;
            return;
        }
        visited[x][y] = true;
        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            dfs(maze, visited, x + dx[i], y + dy[i], endX, endY);
        }
        // 백트래킹
        visited[x][y] = false;
    }
}
