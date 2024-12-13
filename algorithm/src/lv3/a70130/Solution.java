package lv3.a70130;

import util.P;

class Solution {

    int size = 0;
    public int solution(int[] a) {
        if(a.length < 2) return 0;

        //{5,2,3,3,5,3}
        int cnt[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            cnt[a[i]]++;
        }

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if(cnt[i] <= max) continue;

            int temp = 0;
            for (int j = 0; j < a.length-1; j++) {
                if((i==a[j] || i==a[j+1]) && a[j] != a[j+1]) {
                    temp++;
                    j++;
                }
            }
            max = Math.max(temp, max);
        }

        return max*2;
    }
}