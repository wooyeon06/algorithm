package a258705;

//기본문제만 맞음

class Solution2 {

    int diamond[][];

    public int solution(int n, int[] tops) {
        int topCnt = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == 1) {
                topCnt++;
            }
        }

        //1 3 5 7 9
        //0 1 2 3 4

        int dsize = 2 * n + topCnt;
        int num = 0;
        diamond = new int[dsize][2];
        for (int i = 0; i < dsize; i++) {
            if (num % 2 == 1 && tops[num / 2] == 1) {
                diamond[i][0] = num;
                diamond[i][1] = num;
                i++;
            }

            diamond[i][0] = num;
            diamond[i][1] = num + 1;
            num++;
        }


        for (int i = 2; i <= n; i++) {
            cnt = 0;
            recur(0, i, new int[i][2], 0);

            System.out.println("i : " + i + " cnt : " + cnt);
        }

        /*long start = System.currentTimeMillis();
        int i = 12;
        recur(0, i, new int[i][2], 0);
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/

        return (cnt + diamond.length + 1) % 10007;
    }


    int cnt = 0;

    public void recur(int depth, int dcnt, int[][] ncase, int index) {
        if (depth == dcnt) {
            cnt++;
            return;
        }

        for (int i = index; i < diamond.length; i++) {

            boolean pass = false;
            for (int j = 0; j < depth; j++) {
                if (ncase[j][0] == diamond[i][0] || ncase[j][1] == diamond[i][0]) pass = true;
                if (ncase[j][0] == diamond[i][1] || ncase[j][1] == diamond[i][1]) pass = true;
            }

            if (pass) continue;

            ncase[depth] = diamond[i];
            recur(depth + 1, dcnt, ncase, i + 1);
        }
    }


}