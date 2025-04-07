package dp.lv3.a214289;

import java.util.Arrays;

public class Solution {
    //실내온도(t1 ~ t2)

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

        //에어컨 키는 것은 무조건 온도 증가 행위임을 나타내기 위해 temperature 재설정
        temperature = temperature > t2 ? t1 - (temperature - t2) : temperature;
        // t1 --- t2 ---- temperature
        // => temperature (0) --- t2 ---- t1

        t1 = t1 - temperature;
        t2 = t2 - temperature;

        int dp[][] =  new int[onboard.length][t2+2];
        for (int i = 0; i < onboard.length; i++) {
            Arrays.fill(dp[i], 100000);
        }

        //System.out.println("{"+t1+", "+t2+"}");

        dp[0][0] = 0;
        for (int i = 1; i < onboard.length ; i++) {
            for (int j = 0; j <= t2; j++) {
                if(onboard[i] == 1 &&  !(t1 <= j && j <= t2)) {
                    continue;
                }

                int min = 100000;
                if (j == 0) {
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j]); //실외온도 0이라 전력이 소비되지 않음
                    //온도 내리기
                    if (j + 1 <= t2 ) min = Math.min(min, dp[i-1][j+1]);
                }
                else {
                    //온도 올리기
                    if (j - 1 >= 0) min = Math.min(min, dp[i-1][j-1] + a);
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j] + b);
                    //온도 내리기
                    if (j + 1 <= t2 ) min = Math.min(min, dp[i-1][j+1]);
                }

                dp[i][j] = min;

            }
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length-1; i++) {
            if(min > dp[dp.length-1][i]) min = dp[dp.length-1][i];
        }

        return min;
    }
}
