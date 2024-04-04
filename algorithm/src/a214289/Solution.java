    package a214289;

    import util.P;

    import java.util.Arrays;

    class Solution {


        public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

            //-10 ≤ temperature ≤ 40


            temperature = temperature > t2 ? t1 - (temperature - t2) : temperature;

            t1 = t1 - temperature;
            t2 = t2 - temperature;


            //전력소비량
            int[][] DP = new int[onboard.length][t2+2];

            for (int i = 0; i < DP.length ; i++) {
                Arrays.fill(DP[i],100000);
            }

            //온도상승 히터on
            //28,	18,	26,	10,	8,	new int[]{0, 0, 1, 1, 1, 1, 1} // 40
            DP[0][0] = 0;
            for (int i = 1; i < onboard.length ; i++) {
                for (int j = 0; j < t2+1; j++) {

                    if(onboard[i] == 1 &&  !(t1 <= j && j <= t2)) {
                        continue;
                    }

                    int min = 100000;
                    if (j == 0) {
                        //온도 유지하기
                        min = Math.min(min, DP[i-1][j]);
                        //온도 내리기
                        if (j + 1 <= t2 + 1) min = Math.min(min, DP[i-1][j+1]);
                    }
                    else {
                        //온도 올리기
                        if (j - 1 >= 0) min = Math.min(min, DP[i-1][j-1] + a);
                        //온도 유지하기
                        min = Math.min(min, DP[i-1][j] + b);
                        //온도 내리기
                        if (j + 1 <= t2 + 1) min = Math.min(min, DP[i-1][j+1]);
                    }
                    DP[i][j] = min;

                }
            }



            int min = Integer.MAX_VALUE;
            for (int i = 0; i < DP[0].length-1; i++) {
                if(min > DP[DP.length-1][i]) min = DP[DP.length-1][i];
            }


            return min;
        }



    }