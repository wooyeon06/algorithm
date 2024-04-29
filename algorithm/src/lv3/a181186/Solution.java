package lv3.a181186;

import util.P;

class Solution {

    long DP[];
    int MOD = 1000000007;

    public int solution(int n) {
        //1 ≤ n ≤ 100,000
        //결과는 매우 클 수 있으므로 1,000,000,007 로 나눈 나머지를 return합니다.


        /*
        0	1
        1	1
        2	3
        3	10
        4	23
        5	62
        6	170
        7	441
        8	1173
        9	3127
        */

         /*
        2         0
        3         0
        4	2*	(1 * 2)
        5	4*	(1 * 2 + 1 * 2)
        6	14*	(3 * 2 + 1 * 2 + 1 * 4)
        7	32*	(10 * 2 + 3 * 2 + 1 * 4 + 1 * 2)
        8	82*	(23 * 2 + 10 * 2 + 3 * 4 + 1 * 2 + 1 * 2)
        9	222*	(62 * 2 + 23 * 2 + 10 * 4 + 3 * 2 + 1 * 2 + 1 * 4)
        */

        long memo[][];
        if (n <= 6) {
            DP = new long[10];
            memo = new long[3][10];
        } else {
            DP = new long[n + 1];
            memo = new long[3][n + 1];
        }

        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 3;
        DP[3] = 10;
        DP[4] = 23;
        DP[5] = 62;

        memo[0][4] = 2;
        memo[1][4] = 2;
        memo[2][4] = 4;

        memo[0][5] = 4;
        memo[1][5] = 6;
        memo[2][5] = 6;

        memo[0][6] = 16;
        memo[1][6] = 12;
        memo[2][6] = 12;

        int[] i0 = {0, 2, 1};
        int[] i1 = {1, 0, 2};
        int[] i2 = {2, 1, 0};

        for (int i = 6; i <= n; i++) {

            int t0 = i0[(i - 1) % 3];
            int t1 = i1[(i - 1) % 3];
            int t2 = i2[(i - 1) % 3];

            //특수케이스 추가
            if (i > 6) {
                memo[t0][i] = (memo[t0][i - 1] + DP[i - 4] * 2) % MOD;  // 2 2 4
                memo[t1][i] = (memo[t1][i - 1] + DP[i - 4] * 2) % MOD;  // 2 4 2
                memo[t2][i] = (memo[t2][i - 1] + DP[i - 4] * 4) % MOD;  // 4 2 2
            }


            //현재 도형은   이전도형 + 1칸  ,  전전도형 + 2칸( ㄴㄱ과 그반대  ),  전전전 도형 + 5칸(누워있는 5케이스)
            DP[i] = (DP[i - 1] + DP[i - 2] * 2 + DP[i - 3] * 5 + memo[t1][i]) % MOD;

        }


        return (int) DP[n];
    }


}



 /* 메모를 풀어 쓸 경우..
for (int j = i-4 ; j >= 0  ; j-=3) {
    DP[i] = (DP[i] + DP[j] * 2) % MOD;
    if(j - 1 >= 0) {
        DP[i] = (DP[i] + DP[j-1] * 2) % MOD;
    }
    if(j - 2 >= 0) {
        DP[i] = (DP[i] + DP[j-2] * 4) % MOD;
    }
}
 */