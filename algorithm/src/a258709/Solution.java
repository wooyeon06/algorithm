package a258709;

class Solution {

    int n = 0;
    int[][] dice;
    int[][] diceA;
    int[][] diceB;
    char[] select;
    int[] caseA;
    int[] caseB;

    int cntA = 0;
    int cntB = 0;

    int max = 0;
    int[] answer;

    public int[] solution(int[][] _dice) {


        dice = _dice;
        n = dice.length/2;

        caseA = new int[(int) Math.pow(dice[0].length , n)];
        caseB = new int[(int) Math.pow(dice[0].length , n)];

        diceA = new int[n][dice[0].length];
        diceB = new int[n][dice[0].length];

        select = new char[dice.length];
        for (int i = 0; i < dice.length; i++) {
            select[i] = 'B';
        }

        answer = new int[n];

        //init=====================================

        for (int i = 1; i < dice.length; i++) {
            select[i] = 'A';
            selectDice(i, 0);
            select[i] = 'B';
        }


        return answer;
    }


    public void caseA(int d, int v) {
        if(d == diceA.length) {
            caseA[cntA] = v;
            cntA++;
            return;
        }

        for (int j = 0; j < diceA[d].length; j++) {
            caseA(d+1, v + diceA[d][j]);
        }
    }

    public void caseB(int d, int v) {
        if(d == diceB.length) {
            caseB[cntB] = v;
            cntB++;
            return;
        }

        for (int j = 0; j < diceB[d].length; j++) {
            caseB(d+1, v + diceB[d][j]);
        }
    }



    public void selectDice(int _select, int depth) {
        if(depth == n-1) {

            for (int i=0, a=0, b=0; i < select.length; i++) {
                if(select[i] == 'A') {
                    diceA[a] = dice[i]; a++;
                } else {
                    diceB[b] = dice[i]; b++;
                }
            }

            //System.out.println("before :" + System.currentTimeMillis());
            cntA=0;
            caseA(0, 0);
            cntB=0;
            caseB(0, 0);
            //System.out.println("after : " + System.currentTimeMillis() + "  "  );

            int cnt = 0;
            int cnt2 = 0;
            for (int i = 0; i < caseA.length; i++) {
                for (int j = 0; j < caseB.length; j++) {
                    if(caseA[i] > caseB[j]) {
                        cnt++;
                    } else if(caseA[i] < caseB[j]) {
                        cnt2++;
                    }
                }
            }


            if(cnt > max) {
                max = cnt;
                int k = 0;
                for (int i = 0; i < dice.length; i++) {
                    if(select[i] == 'A') {
                        answer[k] = i+1;
                        k++;
                    }
                }
            }
            if(cnt2 > max) {
                max = cnt2;
                int k = 0;
                for (int i = 0; i < dice.length; i++) {
                    if(select[i] == 'B') {
                        answer[k] = i+1;
                        k++;
                    }
                }
            }


            return;
        }

        depth++;
        for (int i = _select+1; i < dice.length; i++) {
            select[i] = 'A';
            selectDice(i, depth);
            select[i] = 'B';
        }
    }

}