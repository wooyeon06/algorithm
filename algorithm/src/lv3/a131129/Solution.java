package lv3.a131129;

import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[]{0, 0};


        int dp[][] = new int[target+1][2];
        for(int i=0; i<=target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        //0 - 던진 횟수
        //1 - 볼/싱클 횟수

        dp[0][0] = 0;
        dp[0][1] = 0;

        //i 현재점수

        //target 50
        for (int i = 1; i <= target ; i++) {
            for (int j = 1; j <= 20; j++) {

                //볼
                if(i >= 50) {
                    if(dp[i][0] > dp[i-50][0]+1){
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }
                    else if(dp[i][0] == dp[i-50][0]+1){ //같은 다트 수라면, 불/싱글을 더 많이 쏘는 경우로 갱신
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1);
                    }
                }

                //싱글
                if(i-j>=0){
                    if(dp[i][0] > dp[i-j][0]+1){
                        dp[i][0] = dp[i-j][0]+1;
                        dp[i][1] = dp[i-j][1]+1;
                    }
                    else if(dp[i][0] == dp[i-j][0]+1){ //같은 다트 수라면, 불/싱글을 더 많이 쏘는 경우로 갱신
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1]+1);
                    }
                }

                //더블
                if(i-2*j>=0){
                    if(dp[i][0] > dp[i-2*j][0]+1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                }

                //트리플
                if(i-3*j>=0){
                    if(dp[i][0] > dp[i-3*j][0]+1){
                        dp[i][0] = dp[i-3*j][0]+1;
                        dp[i][1] = dp[i-3*j][1];
                    }
                }
            }
        }


        answer[0] = dp[target][0];
        answer[1] = dp[target][1];


        return answer;
    }
}