package lv3.a87694;

import util.P;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    boolean visit[][];
    int paint[][];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}
        // 좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y
        //character 1, 3,             1 <= x, y <= 50 ,  1<= 세로 size <=4
        //item 7, 8
        int size = 51;

        characterX *=2;
        characterY *=2;
        itemX *=2;
        itemY *=2;
        size *= 2;

        visit = new boolean[size][size];
        paint = new int[size][size];
        for (int[] rec : rectangle) {
            int x1=rec[0]*2, y1=rec[1]*2, x2=rec[2]*2, y2=rec[3]*2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    paint[i][j] = 1;
                }
            }
        }

        for (int[] rec : rectangle) {
            int x1=rec[0]*2, y1=rec[1]*2, x2=rec[2]*2, y2=rec[3]*2;
            for (int i = x1+1; i < x2; i++) {
                for (int j = y1+1; j < y2; j++) {
                    paint[i][j] = 0;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});

        int dir[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == itemX && cur[1] == itemY) {
                min = Math.min(min, cur[2]);
            }

            if(visit[cur[0]][cur[1]]) continue;
            visit[cur[0]][cur[1]] = true;

            for (int d[] : dir) {
                int r = d[0] + cur[0];
                int c = d[1] + cur[1];

                if(r>=0 && c>=0 && paint[r][c] == 1) {
                    q.add(new int[]{r, c, cur[2] + 1});
                }
            }
        }

        return min/2;
    }
}