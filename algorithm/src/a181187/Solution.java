package a181187;

class Solution {
    public long solution(int r1, int r2) {

        long cnt = getDotCnt(r2, false) - getDotCnt(r1, true);
        long answer = cnt*4 + (r2-r1+1)*4;



        System.out.println(answer);
        return answer;
    }

    public long getDotCnt(int r, boolean b) {
        long cnt = 0;

        for (int i = 1; i < r; i++) {
            double x = Math.sqrt((long) Math.pow(r,2) - (long)Math.pow(i,2));

            System.out.println(x);
            if(b && isInteger(x)) {
                cnt--;
            }

            long v =   (long) x;
            cnt = cnt + v;
        }

        return cnt;
    }

    public boolean isInteger(double number) {
        return number % 1 == 0;
    }

}