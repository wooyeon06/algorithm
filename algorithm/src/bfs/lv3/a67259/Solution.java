package bfs.lv3.a67259;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int[][] board) {

        //직선 도로 하나를 만들 때는 100원이 소요되며, 코너를 하나 만들 때는 500
        int size = board.length;
        int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][] memo = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0, 0, -1}); // r, c, sum, d
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {

            int cur[] = q.poll();
            if(cur[0] == size-1 && cur[1] == size-1 ) {
                min = Math.min(min, cur[2]);
            } else {
                if(board[cur[0]][cur[1]] == 1) continue;
                for (int i = 0; i < dir.length; i++) {
                    int r = dir[i][0] + cur[0];
                    int c = dir[i][1] + cur[1];
                    int d = cur[3];

                    if(r < 0 || c < 0 || r >= size || c >= size || board[r][c] == 1) continue;
                    int sum = cur[2] + 100;
                    if(min < sum || sum > memo[r][c]) continue;
                    if(i!=d && -1!=d) {
                        sum += 500;
                    }

                    //System.out.println("{"+r+","+c+"} : " + sum);
                    memo[r][c] = sum;
                    q.add(new int[] {r, c, sum, i});
                }
            }
        }

        return min;
    }
}