package bfs.lv3.a250134;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /*maze[i][j]	의미
    0	빈칸
    1	빨간 수레의 시작 칸
    2	파란 수레의 시작 칸
    3	빨간 수레의 도착 칸
    4	파란 수레의 도착 칸
    5	벽*/
    int[] R = new int[2];
    int[] eR = new int[2];
    int[] B = new int[2];
    int[] eB = new int[2];
    public int solution(int[][] maze) {
        int x = maze.length;
        int y = maze[0].length;

        boolean[][] visitR = new boolean[x][y];
        boolean[][]visitB = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (maze[i][j] == 1) {
                    R[0] = i; R[1] = j;
                } else if (maze[i][j] == 2) {
                    B[0] = i; B[1] = j;
                } else if (maze[i][j] == 3) {
                    eR[0] = i; eR[1] = j;
                } else if (maze[i][j] == 4) {
                    eB[0] = i; eB[1] = j;
                }
            }
        }
        //=====================================================================


        Queue<HashMap> q = new LinkedList<>();

        HashMap map = new HashMap<>();
        map.put("visitR", visitR);
        map.put("visitB", visitB);
        map.put("cur", new int[] {R[0], R[1], B[0], B[1], 0});
        q.add(map);

        int min = Integer.MAX_VALUE;
        int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {

            HashMap m = q.poll();
            int cur[] = (int[]) m.get("cur");

            //System.out.println("R{"+cur[0]+","+cur[1]+"} B{"+cur[2]+","+cur[3]+"}");
            if(maze[cur[0]][cur[1]] == 3 && maze[cur[2]][cur[3]] == 4) min = Math.min(min, cur[4]);
            if(min <= cur[4]) continue;

            boolean[][] vR = deepCopy((boolean[][]) m.get("visitR"));
            boolean[][] vB = deepCopy((boolean[][]) m.get("visitB"));
            vR[cur[0]][cur[1]] = true;
            vB[cur[2]][cur[3]] = true;

            //Red는 도착한 경우
            if(maze[cur[0]][cur[1]] == 3) {
                //Blue
                for (int d[] : dir) {
                    int r = d[0] + cur[2];
                    int c = d[1] + cur[3];
                    if (r < 0 || c < 0 || r >= x || c >= y || maze[r][c] == 5) continue;
                    if(r==cur[0] && c==cur[1]) continue;
                    if(vB[r][c]) continue;

                    HashMap hm = new HashMap<>();
                    hm.put("visitR", vR);
                    hm.put("visitB", vB);
                    hm.put("cur", new int[] {cur[0],cur[1],r,c,cur[4]+1});
                    q.add(hm);
                }
            }
            //Blue는 도착한 경우
            else if(maze[cur[2]][cur[3]] == 4) {
                //Red
                for (int d[] : dir) {
                    int r = d[0] + cur[0];
                    int c = d[1] + cur[1];
                    if (r < 0 || c < 0 || r >= x || c >= y || maze[r][c] == 5) continue;
                    if(r==cur[2] && c==cur[3]) continue;
                    if(vR[r][c]) continue;

                    HashMap hm = new HashMap<>();
                    hm.put("visitR", vR);
                    hm.put("visitB", vB);
                    hm.put("cur", new int[] {r,c,cur[2],cur[3],cur[4]+1});
                    q.add(hm);
                }
            } else {
                //Red
                for (int d[] : dir) {
                    int r = d[0] + cur[0];
                    int c = d[1] + cur[1];
                    if (r < 0 || c < 0 || r >= x || c >= y || maze[r][c] == 5) continue;
                    if (vR[r][c]) continue;

                    //Blue
                    for (int d2[] : dir) {
                        int r2 = d2[0] + cur[2];
                        int c2 = d2[1] + cur[3];
                        if (r2 < 0 || c2 < 0 || r2 >= x || c2 >= y || maze[r2][c2] == 5) continue;

                        //교차의 경우
                        if(cur[0] == r2 && cur[1] == c2 && cur[2] == r && cur[3] == c) continue;
                        //같은 칸으로 이동할 경우
                        if(r==r2 && c==c2) continue;
                        //방문한 경우
                        if(vB[r2][c2]) continue;

                        HashMap hm = new HashMap<>();
                        hm.put("visitR", vR);
                        hm.put("visitB", vB);
                        hm.put("cur", new int[] {r,c,r2,c2,cur[4]+1});
                        q.add(hm);
                    }
                }
            } // } else {
        } //while(!q.isEmpty()) {

        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }


    public boolean[][] deepCopy(boolean [][] source) {
        boolean[][] dest = new boolean[source.length][source[0].length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                dest[i][j] = source[i][j];
            }
        }
        return dest;
    }

}