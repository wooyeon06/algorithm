package dfs.lv3.a131702;

class Solution {

    //0 12시
    //1 3시
    //2 6시
    //3 9시
    int n = 0;
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        int min = Integer.MAX_VALUE;


        for(int i = 0; i < Math.pow(4, n); i++) {
            int[][] copy = deepCopy(clockHands);
            int temp = i;
            int cnt = 0;

            for (int col = 0; col < n; col++) {
                int rotateCnt = temp % 4;
                temp /= 4;
                cnt += rotateCnt;
                rotate(copy, 0, col, rotateCnt);
            }

            for (int row = 1; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if(copy[row-1][col] > 0) {
                        int rotateCnt = (4-copy[row-1][col])%4;
                        cnt += rotateCnt;
                        rotate(copy, row, col, rotateCnt);
                    }
                }
            }


            boolean flag = true;
            for (int col = 0; col < n; col++) {
                if(copy[n-1][col] != 0) flag = false;
            }

            if(flag) min = Math.min(cnt, min);
        }

        return min;
    }


    int dir[][] = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
    private void rotate(int[][] arr, int r , int c, int rotateCnt) {

        for(int[] d : dir) {
            int _r = r+d[0];
            int _c = c+d[1];

            if(_r < 0 || _c < 0 || _r >= n || _c >= n) continue;
            arr[_r][_c] = (arr[_r][_c] + rotateCnt) % 4;


        }

    }

    private int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, n);
        }
        return copy;
    }



}

