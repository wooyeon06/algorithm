package lv3.a86053;


class Solution {

    long a, b;
    int[] g, s, w, t;

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        this.a = a;
        this.b = b;

        this.g = g;
        this.s = s;
        this.w = w;
        this.t = t;

        long hi = Long.MAX_VALUE;
        long low = 0L;
        long mid = 0L;
        while(low+1 < hi) {
            mid = (hi + low) / 2L;
            if(isPossible(mid)) {
                hi = mid;
            } else {
                low = mid;
            }
        }
        return hi;
    }


    public boolean isPossible(long time) {
        long totalGold  = 0L;
        long totalSiver = 0L;
        long total  = 0L;
        for (int i = 0; i < g.length ; i++) {
            long cnt = time / (t[i] * 2L);
            if (time % (2L * t[i]) >= t[i]) cnt++;

            long tmp = Math.min(w[i] * cnt , g[i] + s[i]);

            total += tmp;

            totalGold += Math.min(g[i], tmp);

            totalSiver += Math.min(s[i], tmp);

            if(total >= a+b && totalGold >= a && totalSiver >= b) {
                return true;
            }
        }
        return false;
    }

}