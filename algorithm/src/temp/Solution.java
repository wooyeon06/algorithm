package temp;

import util.P;

import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < stones.length; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) { //윈도우에서 i-k ~ i까지의 범위를 벗어난 경우
                dq.pollFirst();
            }

            while(!dq.isEmpty() && stones[dq.peekLast()] < stones[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            if(i >= k-1) { //처음 k까지 window채우기
                min = Math.min(min, stones[dq.peekFirst()]);
            }
        }
        return min;
    }
}




