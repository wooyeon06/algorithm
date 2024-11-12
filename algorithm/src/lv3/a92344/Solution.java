package lv3.a92344;

import util.P;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skills) {

        //skill
        //type, r1, c1, r2, c2, degree
        //누적합 표기
        int[][] newBoard = new int[board.length+1][board[0].length+1];
        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            r2++; c2++;
            int degree = skill[5];

            if (type == 2) { //회복
                newBoard[r1][c1] += degree;
                newBoard[r2][c2] += degree;
                newBoard[r1][c2] -= degree;
                newBoard[r2][c1] -= degree;
            } else {
                newBoard[r1][c1] -= degree;
                newBoard[r2][c2] -= degree;
                newBoard[r1][c2] += degree;
                newBoard[r2][c1] += degree;
            }
        }

        //행계산
        for (int[] b : newBoard) {
            for (int i = 1; i < b.length; i++) {
                b[i] += b[i-1];
            }
        }

        //열계산
        for (int c = 0; c < newBoard[0].length; c++) {
            for (int r = 1; r < newBoard.length; r++) {
                newBoard[r][c] += newBoard[r-1][c];
            }
        }


        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(newBoard[i][j] + board[i][j] > 0) cnt++;
            }
        }

        return cnt;
    }
}


/*
public int solution(int[][] board, int[][] skills) {
    int cnt = 0;
    //skill
    //type, r1, c1, r2, c2, degree
    for (int[] skill : skills) {
        int type = skill[0];
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        for (int r = r1 ; r <= r2 ; r++) {
            for (int c = c1 ; c <= c2 ; c++) {
                if (type == 1) { //공격
                    board[r][c] -= degree;
                } else {
                    board[r][c] += degree;
                }
            }
        }
    }

    //P.arr2(board);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if(board[i][j] > 0) cnt++;
        }
    }

    return cnt;
}*/