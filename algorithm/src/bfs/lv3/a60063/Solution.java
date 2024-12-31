package bfs.lv3.a60063;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int[][] board) {

        //new int[][] {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}} //7
        int s = board.length;

        HashSet<String> set = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1, 0});

        int dir[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int v = cur[4];

            int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3];
            if(cur[0] > cur[2]) {
                x1 = cur[2];
                x2 = cur[0];
            }
            if(cur[1] > cur[3]) {
                y1 = cur[3];
                y2 = cur[1];
            }

            //System.out.println("{"+x1+","+y1+"} {"+x2+","+y2+"}");
            if(v >= min) {
                continue;
            } else if((x1 == s-1 && y1 == s-1) || (x2 == s-1 && y2 == s-1)) {
                if(min > v) {
                    min = v;
                } else {
                    continue;
                }
            }

            //4방향이동
            for (int i = 0; i < dir.length; i++) {
                int r1 = cur[0] + dir[i][0], c1 = cur[1] + dir[i][1];
                int r2 = cur[2] + dir[i][0], c2 = cur[3] + dir[i][1];

                if (r1 < 0 || c1 < 0 || r1 >= s || c1 >= s || r2 < 0 || c2 < 0 || r2 >= s || c2 >= s
                        || board[r1][c1] == 1 || board[r2][c2] == 1
                ) continue;

                String pos = ""+r1+","+c1+","+r2+","+c2;
                if(!set.contains(pos)) {
                    set.add(pos);
                    q.add(new int[]{r1, c1, r2, c2, v + 1});
                }
            }

            //회전
            if(x1 == x2) {
                if (x1 + 1 < s && x2 + 1 < s && board[x1 + 1][y1] == 0 && board[x2 + 1][y2] == 0) {
                    String pos1 = ""+x1 +","+ y1+"," + (x1+1)+"," + y1;
                    if(!set.contains(pos1)) {
                        set.add(pos1);
                        q.add(new int[]{x1, y1, x1+1, y1, v + 1});
                    }

                    String pos2 = ""+x2+"," + y2+"," + (x2+1)+"," + y2;
                    if(!set.contains(pos2)) {
                        set.add(pos2);
                        q.add(new int[]{x2, y2, x2+1, y2, v + 1});
                    }
                }
                if (x1 - 1 >= 0 && x2 - 1 >= 0 && board[x1 - 1][y1] == 0 && board[x2 - 1][y2] == 0) {
                    String pos1 = ""+(x1-1)+"," + y1+"," + x1+"," + y1;
                    if(!set.contains(pos1)) {
                        set.add(pos1);
                        q.add(new int[]{x1-1, y1, x1, y1, v + 1});
                    }

                    String pos2 = ""+(x2-1)+"," + y2+"," + x2+"," + y2;
                    if(!set.contains(pos2)) {
                        set.add(pos2);
                        q.add(new int[]{x2-1, y2, x2, y2, v + 1});
                    }

                }
            }
            else if(y1 == y2) {
                if (y1 + 1 < s && y2 + 1 < s && board[x1][y1+1] == 0 && board[x2][y2+1] == 0) {
                    q.add(new int[]{x1, y1, x1, y1+1, v + 1});
                    q.add(new int[]{x2, y2, x2, y2+1, v + 1});
                }
                if (y1 - 1 >= 0 && y2 - 1 >= 0 && board[x1][y1-1] == 0 && board[x2][y2-1] == 0) {
                    q.add(new int[]{x1, y1-1, x1, y1, v + 1});
                    q.add(new int[]{x2, y2-1, x2, y2, v + 1});
                }
            }
        }

        return min;
    }
}



