package a214288;

import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {

    boolean log = true;
    int remain;

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;


        ArrayList<int[]>[] list = (ArrayList<int[]>[]) new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            list[i] = new ArrayList<int[]>();
            for (int j = 0; j < reqs.length; j++) {
                if (reqs[j][2] == i) {
                    list[i].add(reqs[j]);
                }
            }
        }

        remain = n - k;
        int info[][] = new int[remain + 2][k + 1];


        /////////////////////////////////////////////////////////////////////
        for (int type = 1; type <= k; type++) {
            for (int N = 1; N <= remain+1; N++) {
                int[] counselor = new int[N];
                int total_wait = 0;

                //초기화
                for (int i = 0; i < counselor.length; i++) {
                    if(list[type].size()==0 || list[type].size() <= i)
                        continue;

                    int item[] = list[type].get(i);
                    for (int j = i; j < counselor.length; j++) {
                        counselor[j] = item[0] + item[1];
                    }
                }

                for (int i = counselor.length; i < list[type].size(); i++) {
                    if(list[type].size()==0 || list[type].size() <= i)
                        continue;

                    int item[] = list[type].get(i);
                    int v1 = item[0] - counselor[0];
                    int take = 0;
                    int wait = 0;

                    for (int j = 1; j < counselor.length; j++) {
                        int v2 = item[0] - counselor[j];
                        if ((v1 >= 0 && v2 >= 0 && v1 > v2)
                                || (v1 < 0 && v2 >= 0)
                                || (v1 < 0 && v2 < 0 && v2 > v1)
                        ) {
                            v1 = v2;
                            take = j;
                        }
                    }

                    if (v1 < 0) wait = Math.abs(v1);
                    counselor[take] = counselor[take] + item[1];
                    total_wait = wait + total_wait;
                }


                info[N][type] = total_wait;

            }
        }




        //int info[][] = new int[사람][유형];
        int DP[][] = new int[n + 1][k + 1];

        for (int i = 0; i < DP.length; i++) {
            Arrays.fill(DP[i], 1000);
        }

        for (int i = 1; i < info.length; i++) {
            DP[i][1] = info[i][1];
        }



        for (int i = 2; i < DP[i].length; i++) {
            for (int j = 0; j < DP.length; j++) {//사람 수
                for (int l = 1; l <= remain+1; l++) {
                    //j=2    l=1 2 3
                    if(j - l > 0) {
                        //사람별 최소값  + 추가된사람분
                        DP[j][i] = Math.min(DP[j - l][i - 1] + info[l][i], DP[j][i]);
                    }

                }
            }
        }

        return DP[DP.length-1][DP[0].length-1];
    }
}