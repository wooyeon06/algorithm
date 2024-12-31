package a1829;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [1, 0, 0, 3]]
        //[4, 5]


        Queue queue = new LinkedList();
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(picture[i][j] != 0 && visit[i][j]==false) {
                    int cnt = 0;

                    queue.add(new int[]{i, j, picture[i][j]});
                    visit[i][j] = true;

                    while(!queue.isEmpty()) {

                        int[] pos = (int[]) queue.poll();

                        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
                        for (int k = 0; k < dir.length; k++) {
                            int row = pos[0] + dir[k][0];
                            int col = pos[1] + dir[k][1];

                            if(row >= 0 && col >= 0 && row < m && col < n && visit[row][col] == false && picture[row][col] == pos[2]) {
                                queue.add(new int[]{row, col, picture[row][col]});
                                visit[row][col] = true;
                            }
                        }
                        cnt++;
                    }

                    if(cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;

                    numberOfArea++;
                }
            }
        }



        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
}