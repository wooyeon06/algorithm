package dfs.lv3.a131703;

class Solution {
    int lenX = 0;
    int lenY = 0;
    int[][] beginning;
    int[][] target;
    int min = Integer.MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        lenX = beginning.length;
        lenY = beginning[0].length;
        this.beginning = beginning;
        this.target = target;

        for (int i = 0; i < Math.pow(2, lenX) ; i++) {
            int temp = i;
            int cnt = 0;

            int[][] copy = deepCopy(beginning);

            //rotate X
            for (int j = 0; j < lenX; j++) {
                int r = temp % 2;
                temp /= 2;
                if(r == 1) {
                    rotateX(j, copy);
                    cnt++;
                }
            }

            //rotate Y
            for (int y = 0; y < lenY; y++) {
                if(copy[0][y] != target[0][y]) {
                    rotateY(y, copy);
                    cnt++;
                }
            }

            if(equal(copy, target)) {
                min = Math.min(cnt, min);
            }
        }

        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void rotateX(int x, int[][] target) {
        for (int i = 0; i < lenY; i++) {
            if (target[x][i] == 0) {
                target[x][i] = 1;
            } else {
                target[x][i] = 0;
            }
        }
    }

    public void rotateY(int y, int[][] target) {
        for (int i = 0; i < lenX; i++) {
            if (target[i][y] == 0) {
                target[i][y] = 1;
            } else {
                target[i][y] = 0;
            }
        }
    }

    public int[][] deepCopy(int[][] source) {
        int dist[][] = new int[lenX][lenY];
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                dist[i][j] = source[i][j];
            }
        }
        return dist;
    }

    public boolean equal(int[][] a, int[][] b) {
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }


}

