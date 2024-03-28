package a250136;


class Solution2 {
    public int solution(int[][] land) {
        int answer = 0;

        int n = land.length;
        int m = land[0].length;


        int quantity[] = new int[m];
        for (int j = 0; j < m; j++) {
            boolean[][] visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    size = 0;
                    recur(i, j, visit, land);
                    quantity[j] = quantity[j] + size;
                }
            }
        }

        for (int i = 0; i < quantity.length; i++) {
            if (answer < quantity[i]) answer = quantity[i];
        }

        return answer;
    }

    int size = 0;
    public void recur(int i, int j, boolean[][] visit, int[][] land) {
        visit[i][j] = true;
        size++;
        if (j + 1 < visit[0].length && !visit[i][j + 1] && land[i][j + 1] == 1) {
            recur(i, j + 1, visit, land);
        }
        if (i + 1 < visit.length && !visit[i + 1][j] && land[i + 1][j] == 1) {
            recur(i + 1, j, visit, land);
        }
        if (i > 0 && !visit[i - 1][j] && land[i - 1][j] == 1) {
            recur(i - 1, j, visit, land);
        }
        if (j > 0 && !visit[i][j - 1] && land[i][j - 1] == 1) {
            recur(i, j - 1, visit, land);
        }
    }

}


