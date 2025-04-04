package etc.a181187;

class Solution {

    public long solution(int r1, int r2) {
        long cnt1 = 0;
        long cnt2 = 0;

        long side = 0;

        long r22 = (long)Math.pow(r2,2);
        long r11 = (long)Math.pow(r1,2);

        for (long i = 1; i < r2; i++) {
            long i2 = (long)Math.pow(i,2);
            cnt2 += (long) Math.sqrt(r22-i2);
            if(i < r1) {
                cnt1 += (long) Math.sqrt(r11-i2);
                if(Math.sqrt((r11-i2))%1==0){
                    side++;
                }
            }
        }
        //System.out.println(r22);

        long result = (cnt2-cnt1)*4 + (r2-r1+1)*4 + side*4;
        return result;
    }
}