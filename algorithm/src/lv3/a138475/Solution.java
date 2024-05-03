package lv3.a138475;

import util.DP;
import util.P;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer> out = new ArrayList<Integer>();

    int[] memo;
    int[][] DP;

    public int[] solution(int e, int[] starts) {
        memo = new int[e + 1];
        DP = new int[e + 1][2];

        /*for (int i = 0; i < starts.length; i++) {
            out.add(sub(starts[i], e));
        }
        */

        DP[e][0] = getCnt(e);
        DP[e][1] = e;

        for (int i = e-1; i >= 0; i--) {
            int cnt = getCnt(i);
            if (DP[i + 1][0] <= cnt) {
                DP[i][0] = cnt;
                DP[i][1] = i;
            } else {
                DP[i][0] = DP[i + 1][0];
                DP[i][1] = DP[i + 1][1];
            }
        }

        for (int i = 0; i < starts.length; i++) {
            out.add(DP[starts[i]][1]);
        }


        P.arr2(DP);
        System.out.println(out);


        int answer[] = out.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }


    public int sub(int start, int end) {


        int max = 0;
        int idx = 0;
        for (int i = start; i <= end; i++) {
            int cnt = 0;
            int v = getCnt(i);
            if (v > max) {
                max = v;
                idx = i;
            }
        }
        return idx;
    }


    public int getCnt(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int bak = n;

        int count = 1;

        // 2부터 제곱근까지의 수를 반복하며 약수를 구합니다.
        for (int i = 2; i * i <= n; i++) {
            int t = 0;
            while (n % i == 0) {
                n /= i;
                t++;
            }
            count *= (t + 1);
        }

        // 마지막으로 남은 수가 1보다 크면, 그 수는 소인수이며 그 지수는 1입니다.
        if (n > 1) {
            count *= 2;
        }

        memo[bak] = count;
        return count;
    }

}