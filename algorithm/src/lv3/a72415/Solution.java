package lv3.a72415;


import java.util.*;

class Solution {
    int size = 4;
    int[][] board;
    int dir[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    ArrayList<int[]>[] list;
    int min = Integer.MAX_VALUE;
    public int solution(int[][] board, int _r, int _c) {
        this.board = board;
        list = new ArrayList[7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int v = board[i][j];
                if(v > 0) {
                    if(list[v] == null) list[v] = new ArrayList<int[]>();
                    list[v].add(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        for(ArrayList l : list) {
            if(l!=null && l.size() == 2) cnt++;
        }

        ///////////////////////////////////////////////////////////////////////////////////


        recur(cnt, _r, _c, 0);

        return min;
    }

    public void recur(int cnt, int _r, int _c, int total) {
        if(total > min) return;

        if(cnt == 0) {
            min = Math.min(min, total);
            System.out.println("min : " + min);
            return;
        }

        int memo[][] = getMemo(_r, _c);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{_r, _c});
        boolean visit[][] = new boolean[size][size];

        while(!q.isEmpty()) {
            int cur[] = q.poll();
            int move = memo[cur[0]][cur[1]]; // {_r, _c}에서 이동한거리

            if(board[cur[0]][cur[1]] > 0 && visit[cur[0]][cur[1]] == false) {
                int[][] memo2 = getMemo(cur[0], cur[1]);
                int character = board[cur[0]][cur[1]];
                for (int[] pos : list[character]) {
                    if(pos[0] != cur[0] || pos[1] != cur[1]) {
                        System.out.println("{" + _r + " , " + _c + "} > {" + cur[0] + " , " + cur[1] + "}  +" + move);
                        board[pos[0]][pos[1]] = 0;
                        board[cur[0]][cur[1]] = 0;
                        recur(cnt -1, pos[0], pos[1], total +  move + memo2[pos[0]][pos[1]] + 2);
                        board[pos[0]][pos[1]] = character;
                        board[cur[0]][cur[1]] = character;
                        System.out.println("{" + cur[0] + " , " + cur[1] + "} > {" + pos[0] + " , " + pos[1] + "}  +" + (memo2[pos[0]][pos[1]] + 2));
                    }
                }
            }
            visit[cur[0]][cur[1]] = true;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(board[i][j] > 0 && visit[i][j] == false) {
                        q.add(new int[]{i, j});
                    }
                }
            }

            ///////////////////////////////////////////////////////////
        }
    }


    public int[][] getMemo(int _r, int _c) {
        int memo[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(memo[i], 10);
        }

        boolean visit[][] = new boolean[size][size];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {_r, _c, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            memo[cur[0]][cur[1]] = Math.min(cur[2], memo[cur[0]][cur[1]]);

            if(visit[cur[0]][cur[1]]) continue;
            visit[cur[0]][cur[1]] = true;

            //ctrl 이동
            for (int i = 0; i < 4; i++) {
                int r = cur[0];
                int c = cur[1];
                if (i == 0) {
                    while (r < size-1) {
                        r++;
                        if (board[r][c] > 0) break;
                    }
                    q.add(new int[]{r, c, cur[2] + 1});
                } else if (i == 1) {
                    while (r > 0) {
                        r--;
                        if (board[r][c] > 0) break;
                    }
                    q.add(new int[]{r, c, cur[2] + 1});
                } else if (i == 2) {
                    while (c < size-1) {
                        c++;
                        if (board[r][c] > 0) break;
                    }
                    q.add(new int[]{r, c, cur[2] + 1});
                } else if (i == 3) {
                    while (c > 0) {
                        c--;
                        if (board[r][c] > 0) break;
                    }
                    q.add(new int[]{r, c, cur[2] + 1});
                }
            }

            for (int[] d : dir) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if(r < 0 || c < 0 || r >= size || c >= size || visit[r][c]) continue;
                q.add(new int[]{r, c, cur[2] + 1});
            }
        }
        return memo;
    }


}