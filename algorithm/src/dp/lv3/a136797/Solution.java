package dp.lv3.a136797;

import java.util.Arrays;

class Solution {

    public int[][] cost = {
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    int dp[][][];
    int[] numbers;
    public int solution(String sNumbers) {
        numbers = new int[sNumbers.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Character.getNumericValue(sNumbers.charAt(i));
        }
        dp = new int[numbers.length+1][10][10];
        for (int i = 0; i < numbers.length+1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return getDistance(0, 4, 6);
    }

    public int getDistance(int depth, int L, int R) {
        if(depth == numbers.length) return 0;
        //이미 계산된건 리턴
        //dp에 저장된 값은 최소값을 보장하기 때문에 return
        //cost에 저장된 값이 이미 노드간 최단 거리이기 때문에
        //dp에 저장되는 값은 항상 최단거리 a>(왼손)b  a>(오른손)b로 갈 때
        if(dp[depth][L][R] != Integer.MAX_VALUE) {
            return dp[depth][L][R];
        }

        int result = Integer.MAX_VALUE;
        int num = numbers[depth];

        //왼쪽
        if(R == num) {}
        else {
            if(L == num) { //같을 경우 +1을 추가해야되기 때문
                //System.out.println("L : " + L);
            }
            result = Math.min(getDistance(depth + 1, num, R) + cost[L][num], result);
        }

        //오른쪽
        if(L == num) {}
        else {
            if(R == num) {  //같을 경우 +1을 추가해야되기 때문
                //System.out.println("R : " + R);
            }
            result = Math.min(getDistance(depth + 1, L, num) + cost[num][R], result);
        }

        dp[depth][L][R] = result;
        return result;

    }
}