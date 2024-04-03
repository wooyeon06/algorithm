package a250125;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int k = 0; k < dir.length; k++) {
            int _i = h + dir[k][0];
            int _j = w + dir[k][1];

            if (_i < 0 || _j < 0 || _i >= board.length || _j >= board[0].length) continue;
            if (board[h][w].equals(board[_i][_j])) {
                answer++;
            }
        }


        return answer;
    }
}