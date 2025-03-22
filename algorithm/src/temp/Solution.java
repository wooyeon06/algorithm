package temp;

class Solution {

    //0 12시
    //1 3시
    //2 6시
    //3 9시
    public int solution(int[][] clockHands) {
        int len = clockHands.length;
        int cnt = 0;

        int dir[][] = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if(clockHands[i-1][j] > 0) {
                    int rot = 4-clockHands[i-1][j];
                    for (int[] d : dir) {

                        int r = d[0] + i;
                        int c = d[1] + j;

                        if(r < 0 || c < 0 || r >= len || c >= len) continue;
                        clockHands[r][c] += rot;
                    }
                }

            }
        }



        return 0;
    }
}

