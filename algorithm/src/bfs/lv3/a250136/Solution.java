package bfs.lv3.a250136;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[][] land) {

        int sum[] = new int[land[0].length];
        boolean[][] visit = new boolean[land.length][land[0].length];
        Queue<int[]> q = new LinkedList();
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {

                if(!visit[i][j] && land[i][j] == 1) {
                    q.clear();
                    q.add(new int[] {i, j});
                    ArrayList<int[]> list = new ArrayList();
                    while(!q.isEmpty()) {
                        int cur[] = q.poll();
                        if(visit[cur[0]][cur[1]]) continue;
                        visit[cur[0]][cur[1]] = true;
                        list.add(new int[] {cur[0], cur[1]});
                        for (int[] d : dir) {
                            int r = cur[0] + d[0];
                            int c = cur[1] + d[1];

                            if(r < 0 || c < 0 || r >= land.length || c >= land[0].length || visit[r][c] || land[r][c] == 0) continue;
                            q.add(new int[]{r, c});
                        }
                    } // end of while(!q.isEmpty()) {

                    boolean[] sumV = new boolean[land[1].length];
                    for(int loc[] : list) {
                        land[loc[0]][loc[1]] = list.size();
                        if(!sumV[loc[1]]) {
                            sum[loc[1]] += list.size();
                            sumV[loc[1]] = true;
                        }
                    }
                }
            }
        }


        int max = 0;
        for (int s : sum) {
            max = Integer.max(s, max);
        }
        return max;
    }

}