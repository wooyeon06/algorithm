package bfs.lv3.a250136;

import java.util.*;

public class Solution3 {

    int id = 2;
    int[][] dir = new int[][]{
            {0, 0}, {0, 1}, {0,-1}, {1,0}, {-1, 0}
    };
    Map<Integer, Integer> info = new HashMap<Integer, Integer>();

    public int solution(int[][] land) {


        //init
        for (int i = 0; i < land.length; i++) {   // 아래
            for (int j = 0; j < land[0].length; j++) { // 오른쪽
                if (land[i][j] == 1) {
                    set(land, i, j);
                }
            }
        }

        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j = 0; j < land[0].length; j++) {
            set.clear();
            for (int i = 0; i < land.length; i++) {
                set.add(land[i][j]);
            }

            Iterator iter = set.iterator();
            int temp = 0;
            while(iter.hasNext()) {
                int _temp = (int) iter.next();
                if(_temp > 1) {
                    temp = temp + info.get(_temp);
                }
            }

            if(temp > max) {
                max = temp;
            }
        }

        return max;
    }




    public void set(int [][]land, int i, int j) {

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{i, j});


        int[] cur = new int[2];
        cur[0] = i;
        cur[1] = j;

        while(!queue.isEmpty()) {

            cur = queue.poll();

            for (int k = 0; k <= 4; k++) {
                int r = cur[0] + dir[k][0];
                int c = cur[1] + dir[k][1];

                if(r<0 || c<0 || r>=land.length || c>=land[0].length || land[r][c]!=1){
                    continue;
                }


                land[r][c] = id;
                queue.add(new int[]{r, c});

                if(info.get(land[r][c]) == null) {
                    info.put(land[r][c], 1);
                } else {
                    info.put(land[r][c], info.get(land[r][c])+1);
                }

            }
        }

        id++;
    }

}
