package dp.lv3.a68646;

import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
        //new int[]{9,-1,-5}  > 3

        //인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 할 수 있습니다
        //풍선들을 1개만 남을 때까지 터트렸을 때 최후까지 남기는 것이 가능한 풍선들의 개수

        //9가 작은개 1개 큰개 여러개

        int min[][] = new int[2][a.length];

        Arrays.fill(min[0], Integer.MAX_VALUE); //left
        Arrays.fill(min[1], Integer.MAX_VALUE); //right

        min[0][0] = a[0];
        min[1][a.length-1] = a[a.length-1];

        int j=a.length-2;
        for (int i = 1; i < a.length; i++) {
            min[0][i] = Math.min(a[i], min[0][i-1]);
            min[1][j] = Math.min(a[j], min[1][j+1]);
            j--;
        }

        int cnt = 0;
        for (int i = 1; i < a.length-1; i++) {
            if(a[i] > min[0][i-1] && a[i] > min[1][i+1]) {
                cnt++;
            }
        }

        return a.length - cnt;
    }
}