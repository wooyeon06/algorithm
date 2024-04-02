package a250134;

import util.P;

class Solution {

    int[][] maze;
    int x, y;

    int[] R = new int[2];
    int[] eR = new int[2];
    int[] B = new int[2];
    int[] eB = new int[2];

    boolean[][] visitR;
    boolean[][] visitB;

    int min = 100000;
    public int solution(int[][] maze) {

        this.maze = maze;

        x = maze[0].length;
        y = maze.length;

        visitR = new boolean[y][x];
        visitB = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (maze[i][j] == 1) {
                    R[0] = i;
                    R[1] = j;
                } else if (maze[i][j] == 2) {
                    B[0] = i;
                    B[1] = j;
                } else if (maze[i][j] == 3) {
                    eR[0] = i;
                    eR[1] = j;
                } else if (maze[i][j] == 4) {
                    eB[0] = i;
                    eB[1] = j;
                }
            }
        }

        visitR[R[0]][R[1]] = true;
        visitB[B[0]][B[1]] = true;
        ////////////////////////////////////// init


        recur(0, R[1], R[0], B[1], B[0]);

        if(100000 == min)
            return 0;

        return min;
    }


    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void recur(int step, int Rx, int Ry, int Bx, int By) {

        if ((Ry == eR[0] && Rx == eR[1]) && (By == eB[0] && Bx == eB[1])) {
            if(step < min) min = step;
            return;
        }

        if((Ry == eR[0] && Rx == eR[1])) { // Red만 도착
            for (int j = 0; j < dir.length; j++) {
                int _By = By + dir[j][0];
                int _Bx = Bx + dir[j][1];
                if (_By < 0 || _Bx < 0 || _Bx >= this.x || _By >= this.y || visitB[_By][_Bx] == true || maze[_By][_Bx] == 5  || (_By == Ry && _Bx == Rx)) {
                    continue;
                } else {
                    visitB[_By][_Bx] = true;
                    recur(step + 1, Rx, Ry, _Bx, _By);
                    visitB[_By][_Bx] = false;
                }
            }
        } else if(By == eB[0] && Bx == eB[1]) { //Blue만도착
            for (int j = 0; j < dir.length; j++) {
                int _Ry = Ry + dir[j][0];
                int _Rx = Rx + dir[j][1];

                if (_Ry < 0 || _Rx < 0 || _Rx >= this.x || _Ry >= this.y || visitR[_Ry][_Rx] == true || maze[_Ry][_Rx] == 5 || (By == _Ry && Bx == _Rx)) {
                    continue;
                } else {
                    visitR[_Ry][_Rx] = true;
                    recur(step + 1, _Rx, _Ry, Bx, By);
                    visitR[_Ry][_Rx] = false;
                }
            }
        } else {
            for (int i = 0; i < dir.length; i++) {
                int _Ry = Ry + dir[i][0];
                int _Rx = Rx + dir[i][1];

                //벽 또는 방문
                if (_Ry < 0 || _Rx < 0 || _Rx >= this.x || _Ry >= this.y || visitR[_Ry][_Rx] == true || maze[_Ry][_Rx] == 5) {
                    continue;
                } else {
                    visitR[_Ry][_Rx] = true;

                    for (int j = 0; j < dir.length; j++) {
                        int _By = By + dir[j][0];
                        int _Bx = Bx + dir[j][1];

                        //교차되는 경우 제외
                        if(_By == Ry && _Bx == Rx && By == _Ry && Bx == _Rx) {
                            continue;
                        }
                        //서로 같은 칸이동 제외
                        if(_By == _Ry && _Bx == _Rx) {
                            continue;
                        }


                        if (_By < 0 || _Bx < 0 || _Bx >= this.x || _By >= this.y || visitB[_By][_Bx] == true || maze[_By][_Bx] == 5) {
                            continue;
                        } else {
                            //System.out.println("step : "+ step+"  Rx : " + _Rx + ",  Ry : " + _Ry + " || Bx : " + _Bx + ",  By : " + _By);
                            visitB[_By][_Bx] = true;
                            recur(step + 1, _Rx, _Ry, _Bx, _By);
                            visitB[_By][_Bx] = false;
                        }
                    }
                    visitR[_Ry][_Rx] = false;
                }
            }
        }




    }


}