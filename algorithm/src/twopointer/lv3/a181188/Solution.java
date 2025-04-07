package twopointer.lv3.a181188;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, Comparator.comparingInt(a -> a[0]));

        //겹치는 부분
        int s = targets[0][0];
        int e = targets[0][1];
        int cnt = 1;

        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            if(e <= target[0]) { //안겹치는 부분 생김
                System.out.println("before {"+s+" , "+e+"}");
                s = target[0];
                e = target[1];
                cnt++;
                System.out.println("after {"+s+" , "+e+"}\n");
            } else { //겹치는 부분 갱신
                s = Math.max(s, target[0]);
                e = Math.min(e, target[1]);
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}