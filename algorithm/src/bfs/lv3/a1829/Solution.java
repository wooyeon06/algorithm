package bfs.lv3.a1829;


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[] solution(int m, int n, int[][] picture) {

        Queue<int[]> q = new LinkedList<>();
        boolean v[][] = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] == 0 || v[i][j]) continue;
                q.add(new int[]{i, j});
                v[i][j] = true;

                int cnt = 1;
                while(!q.isEmpty()) {
                    int cur[] = q.poll();
                    for (int[] d : dir) {
                        int r = d[0] + cur[0];
                        int c = d[1] + cur[1];
                        if(r < 0 || c < 0 || r >= m || c >= n || v[r][c] || picture[r][c] == 0) continue;
                        if(picture[cur[0]][cur[1]] == picture[r][c]) {
                            cnt++;

                            v[r][c] = true;
                            q.add(new int[]{r, c});
                        }
                    }
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                numberOfArea++;
            }
        }
        System.out.println(numberOfArea + ", " + maxSizeOfOneArea);
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}

