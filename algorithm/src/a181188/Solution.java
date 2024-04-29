package a181188;



import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 첫 번째 요소를 기준으로 정렬하기 위해 Comparator를 구현합니다.
        Arrays.sort(targets, Comparator.comparingInt(a -> a[0]));

        // 정렬된 배열을 출력합니다.
        int cnt = 0;
        int a = -1, b = -1;
        for (int[] arr : targets) {
            if((a < arr[0] && arr[0] < b) || arr[0] == a) {
                a = arr[0];
                if(arr[1] <= b) {
                    b = arr[1];
                }
            } else {
                a = arr[0];
                b = arr[1];
                //System.out.println("!!!  a : " + a + "   b : " + b);
                cnt++;
            }
            //System.out.println("a : " + a + "   b : " + b);
        }

        
        return cnt;
    }
}