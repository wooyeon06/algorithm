package dp.lv3.a258705;/*
class Solution {

    public int solution(int n, int[] tops) {

        int dp[] = new int[n];

        if(tops[0] == 0) dp[0] = 3;
        if(tops[0] == 1) dp[0] = 4;

        for (int i = 1; i < n; i++) {
            if(i==1) {
                if(tops[i] == 1) {
                    dp[i] = dp[i-1] * 4 - 1;
                } else {
                    dp[i] = dp[i-1] * 3 - 1;
                }
            } else {
                if(tops[i] == 1) {
                    if(tops[i-1] == 1) {
                        dp[i] = (dp[i-1] * 3 + dp[i-2] * 3) % 10007;
                    } else {
                        dp[i] = (dp[i-1] * 3 + dp[i-2] * 2) % 10007;
                    }
                } else {
                    if(tops[i-1] == 1) {
                        dp[i] = (dp[i-1] * 2 + dp[i-2] * 2) % 10007;
                    } else {
                        dp[i] = (dp[i-1] * 2 + dp[i-2]) % 10007;
                    }
                }
            }
        }

        P.arr(dp);

        return dp[n-1];
    }
}*/


class Solution {

    public int solution(int n, int[] tops) {

        
        
        int dpA[] = new int[n]; //i번째 오른쪽 마름모 기준일 때의 개수
        int dpB[] = new int[n]; //그 외 개수

        dpA[0] = 1;
        if(tops[0] == 0) dpB[0] = 2;
        if(tops[0] == 1) dpB[0] = 3;


        for (int i = 1; i < n; i++) {

            dpA[i] = ( dpA[i-1] + dpB[i-1] ) % 10007;

            if(tops[i] == 1) {
                dpB[i] =  (dpA[i-1] * 2+ dpB[i-1] * 3) % 10007;
            } else {
                dpB[i] =  (dpA[i-1] + dpB[i-1] * 2) % 10007;
            }

        }


        return ( dpA[n-1] + dpB[n-1] ) % 10007;
    }
}