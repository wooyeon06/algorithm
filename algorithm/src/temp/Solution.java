package temp;

import util.P;

import java.util.*;


class Solution {
    public int solution(int[][] board) {

        //new int[][] {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}} //7
        int s = board.length;

        boolean[][] lvisit = new boolean[s][s];
        boolean[][] rvisit = new boolean[s][s];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1, 0});

        int dir[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int hrot[][] = new int[][]{{1, 1}, {-1, 1}, {-1, -1}, {1, -1}}; //왼쪽 2 오른쪽2
        int vrot[][] = new int[][]{{1, -1}, {1, 1}, {-1, -1}, {-1, 1}}; //위2  아래2

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int v = cur[4];

            if(v > 7) {
                continue;
            } else {
                System.out.println(v);
            }

            //회전
            if(cur[0] == cur[2]) {
                int x1 = cur[0], x2 = cur[1], y1 = cur[2], y2 = cur[3];
                if (x1 + 1 < s && x2 + 1 < s && board[x1 + 1][y1] == 0 && board[x2 + 1][y2] == 0) {
                    if (y1 < y2) {
                        q.add(new int[]{x1 + 1, y1 + 1, x2, y2, v + 1});
                        q.add(new int[]{x1, y1, x2 + 1, y2 - 1, v + 1});
                    } else {
                        q.add(new int[]{x1, y1, x2 + 1, y2 - 1, v + 1});
                        q.add(new int[]{x1 + 1, y1 + 1, x2, y2, v + 1});
                    }
                }
                if (x1 - 1 >= 0 && x2 - 1 >= 0 && board[x1 - 1][y1] == 0 && board[x2 - 1][y2] == 0) {
                    if (y1 < y2) {
                        q.add(new int[]{x1 - 1, y1 + 1, x2, y2, v + 1});
                        q.add(new int[]{x1, y1, x2 - 1, y2 - 1, v + 1});
                    } else {
                        q.add(new int[]{x1, y1, x2 - 1, y2 - 1, v + 1});
                        q.add(new int[]{x1 - 1, y1 + 1, x2, y2, v + 1});
                    }
                }
            }

            //4방향이동
            for (int i = 0; i < dir.length; i++) {
                int r1 = cur[0] + dir[i][0], c1 = cur[1] + dir[i][1];
                int r2 = cur[2] + dir[i][0], c2 = cur[3] + dir[i][1];

                if (r1 < 0 || c1 < 0 || r1 >= s || c1 >= s || r2 < 0 || c2 < 0 || r2 >= s || c2 >= s
                        || board[r1][c1] == 1 || board[r2][c2] == 1
                ) continue;

                q.add(new int[]{r1, c1, r2, c2, v + 1});
            }
        }

        int answer = 0;
        return answer;
    }
}



