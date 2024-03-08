package a258712;

//100

import java.util.*;

class Solution {

    Map index = new HashMap();

    int[]factor;
    int[][] info;
    int max = 0;

    public int solution(String[] friends, String[] gifts) {
        init(friends, gifts);
        for (int i = 0; i < info.length; i++) {

            int cnt = 0;
            for (int j = 0; j < info[i].length; j++) {
                if(info[i][j] > info[j][i]) {
                    cnt++;
                } else if(info[i][j] == info[j][i]) {

                    //int _i = Integer.valueOf(factor.get(String.valueOf(friends[i])));
                    int _i = factor[i];
                    int _j = factor[j];

                    if(_i > _j) {
                        cnt++;
                    }

                }
            }

            if(max < cnt) {
                max = cnt;
            }
        }
        int answer = max;
        return answer;
    }


    public void init(String[] friends, String[] gifts) {
        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }


        factor = new int[friends.length];
        info = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] item = gifts[i].split(" ");

            int _i = (int) index.get(item[0]);
            int _j = (int) index.get(item[1]);
            info[_i][_j]++;

            factor[_i]++;
            factor[_j]--;

        }


    }


}