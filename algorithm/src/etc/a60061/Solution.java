package etc.a60061;

class Solution {

    boolean[][] bo;
    boolean[][] gidoong;
    int n;
    public int[][] solution(int n, int[][] build_frames) {
        this.n = n;
        gidoong = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];

        //a는 설치 또는 삭제할 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.
        //b는 구조물을 설치할 지, 혹은 삭제할 지를 나타내며 0은 삭제, 1은 설치를 나타냅니다.
        int dir[][] = new int[][]{{0,0}, {1,0}, {-1,0}, {0,-1}, {0,1}, {1,1}, {-1,-1}, {-1,1}, {1,-1}};
        for (int[] build_frame : build_frames) {
            int x = build_frame[0], y = build_frame[1];
            int a = build_frame[2], b = build_frame[3];
            if(b==0) { //삭제
                if(a==0) { //기둥삭제
                    gidoong[x][y] = false;
                    for(int d[] : dir) {
                        int r = x + d[0];
                        int c = y + d[1];
                        if(r<0 || c<0 || r>n || c>n) continue;
                        if(gidoong[r][c] && !check(r, c, 0)) {
                            gidoong[x][y] = true; //복원
                            break;
                        }
                        if(bo[r][c] && !check(r, c, 1)) {
                            gidoong[x][y] = true; //복원
                            break;
                        }
                    }
                } else {
                    bo[x][y] = false;
                    for(int d[] : dir) {
                        int r = x + d[0];
                        int c = y + d[1];
                        if(r<0 || c<0 || r>n || c>n) continue;
                        if(gidoong[r][c] && !check(r, c, 0)) {
                            bo[x][y] = true; //복원
                            break;
                        }
                        if(bo[r][c] && !check(r, c, 1)) {
                            bo[x][y] = true; //복원
                            break;
                        }
                    }
                }
            } else if(b==1) { //설치
                if(check(x, y, a)) {
                    if(a==0) { //기동
                       gidoong[x][y] = true;
                    } else { //보
                       bo[x][y] = true;
                    }
                }
            }
        }

        /// ///////////////////////////////////////////////////////////////////////////
        int cnt = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(gidoong[i][j]) cnt++;
                if(bo[i][j]) cnt++;
            }
        }
        int result[][] = new int[cnt][3];
        int idx = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(gidoong[i][j])  result[idx++] = new int[]{i, j, 0};
                if(bo[i][j]) result[idx++] = new int[]{i, j, 1};
            }
        }

        for (int i = 0; i < idx; i++) P.arr(result[i]);
        return result;
    }

    public boolean check(int x, int y, int a) {
        if(a==0) { //기동
            if(y==0 || (y-1 >=0 && gidoong[x][y-1]) || bo[x][y] ||(x-1 >=0 && bo[x-1][y])) {
                return true;
            }
        } else if(a==1) { //보
            if(
                (x-1>=0 && x+1<= n && bo[x-1][y] && bo[x+1][y]) ||
                (y-1>=0 && gidoong[x][y-1]) ||
                (x+1<= n && y-1>=0 && gidoong[x+1][y-1])
            ) {
                return true;
            }
        }
        return false;
    }

}