package lv2.a178870;


class Solution {
    public int[] solution(int[] sequence, int k) {
        int range = Integer.MAX_VALUE;
        int sum = 0;
        int len = sequence.length;

        int s = 0;
        int e = 0;
        for (int L=0, R=0; L < len; L++) {
            while(sum < k && R < len) {
                sum += sequence[R];
                R++;
            }

            if(sum == k) {
                if(R-L-1 < range) {
                    range = R-L-1;
                    s = L;
                    e = R-1;
                }
            }

            sum -= sequence[L];
        }


        System.out.println("{"+s+","+e+"}");

        int[] answer = new int[]{s, e};
        return answer;
    }
}