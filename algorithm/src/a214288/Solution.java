package a214288;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    int remain;
    int[][] reqs;

    public int solution(int k, int n, int[][] reqs) {

        //k 3,	n 5,	new int[][] {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}} //25

        this.reqs = reqs;

        ArrayList list = new ArrayList();
        for (int i = 0; i < k; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(0);
            list.add(queue);
        }

        recur(0,n-k, k, list);

        return min;
    }

    public int mainLoop(ArrayList origin, int[][] reqs) {
        //new int[][] {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}} //25

        ArrayList list = new ArrayList();
        for (int i = 0; i < origin.size(); i++) {
            PriorityQueue<Integer> copiedQueue = new PriorityQueue<>((PriorityQueue) origin.get(i));
            list.add(copiedQueue);
        }


        int wating = 0;
        for (int i = 0; i < reqs.length; i++) {
            int[] item = reqs[i];

            PriorityQueue q = (PriorityQueue) list.get(item[2]-1);
            if(!q.isEmpty()) {
                int t = (int) q.poll();

                //처음 큐에 add
                if(t == 0) {
                    t = item[0] +  item[1];
                } else { //그 외...

                    //대기시간 발생
                    if(t > item[0]) {
                        //System.out.println("start : " + item[0] + " long : " + item[1]+ "  type : " + item[2]);

                        wating = wating + (t - item[0]);
                        if(wating > min) return Integer.MAX_VALUE;

                        t = t + item[1];
                    } else if(t < item[0]) {
                        t = t + item[1] + (item[0] - t);
                    } else {
                        t = t + item[1];
                    }
                }

                q.add(t);

            }
            //System.out.println(list);
        }
        return wating;
    }


    int min = Integer.MAX_VALUE;
    public void recur(int s, int n, int k, ArrayList list) {
        if(n==0) {
            //main 실행
            int wating = mainLoop(list, reqs);
            if(min > wating) min = wating;
            return;
        }

        //유형
        for (int i = s; i < k; i++) {
            PriorityQueue q = (PriorityQueue) list.get(i);
            q.add(0);
            recur(i, n-1, k, list);
            q.poll();
        }
    }

}
