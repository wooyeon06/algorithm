package lv3.a87391;

import util.P;

import java.util.*;

class Solution {
    public long solution(long n, long m, int x, int y, int[][] queries) {
        //행의 개수 n, 열의 개수 m, 정수 x와 y
        long top = x, bottom = x, left = y, right = y;
        for (int i = queries.length-1; i >= 0 ; i--) {
            int command = queries[i][0];
            int move = queries[i][1];
            if (command == 0) { // 열 번호가 감소하는 방향으로 dx칸 이동하는 쿼리
                if (left != 0) left += move;
                right = Math.min(m-1, right + move);
            } else if (command == 1) { // 열 번호가 증가하는 방향으로 dx칸 이동하는 쿼리
                if (right != m-1) right -= move;
                left = Math.max(0, left - move);
            } else if (command == 2) { // 행 번호가 감소하는 방향으로 dx칸 이동하는 쿼리
                if (top != 0)  top += move;
                bottom = Math.min(n-1, bottom + move);
            } else if (command == 3) { // 행 번호가 증가하는 방향으로 dx칸 이동하는 쿼리
                if (bottom != n-1) bottom -= move;
                top = Math.max(0, top - move);
            }
            // 범위가 격자를 벗어나면 더 이상 유효한 시작점이 없음
            if (left >= m || right < 0 || top >= n || bottom < 0) {
                return 0;
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }


}