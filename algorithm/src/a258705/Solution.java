package a258705;

class Solution {

    public int solution(int n, int[] tops) {

        int dpA[] = new int[n];
        dpA[0] = 1;

        int dpB[] = new int[n];
        dpB[0] = tops[0] == 1? 3 : 2;

        for (int i = 1; i < n ; i++) {

            dpA[i] = (dpA[i-1] + dpB[i-1]) % 10007;

            if(tops[i] == 1) {
                dpB[i] =  (dpA[i-1] * 2+ dpB[i-1] * 3) % 10007;
            } else {
                dpB[i] =  (dpA[i-1] + dpB[i-1] * 2) % 10007;
            }
        }


        int answer = (dpA[n-1] + dpB[n-1]) % 10007;
        return answer;

    }

}