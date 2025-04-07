package scheduleing.lv3.a214288;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    int min = Integer.MAX_VALUE;


    int[][] reqs;
    int n, k;
    ArrayList<PriorityQueue<Integer>> agentList = new ArrayList<>();


    public int solution(int k, int n, int[][] reqs) {
        this.n = n;
        this.k = k;
        this.reqs = reqs;
        for (int i = 0; i < k; i++) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            q.add(0);
            agentList.add(q);
        }
        recur(n-k, 0);
        return min;
    }


    public int proc() {
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < agentList.size(); i++) {
            PriorityQueue<Integer> copiedQueue = new PriorityQueue<>((PriorityQueue) agentList.get(i));
            list.add(copiedQueue);
        }

        int wating = 0;

        for (int[] req : reqs) {
            //5, 55, 1
            int start    = req[0];
            int duration = req[1];
            PriorityQueue<Integer> q = list.get(req[2]-1);

            if(!q.isEmpty()) {
                //상담가능한 인원의 상담이 가능한 시간
                int availTime = q.poll();
                if(availTime == 0) {
                    q.add(start + duration);
                } else {
                    if(availTime > start) { //상담 중이어서 대기시간 발생
                        wating += (availTime - start);
                        q.add(availTime+duration);
                    } else if(availTime < start) {
                        q.add(start+duration);
                    }  else if(availTime == start) {
                        q.add(availTime+duration);
                    }
                }
            } //end of if(!q.isEmpty()) {
        } // for (int[] req : reqs) {
        return wating;
    }

    public void recur(int dep, int t) {
        if(dep == 0) {
            int waiting = proc();
            min = Math.min(waiting, min);
            return;
        }

        //유형
        for (int i = t; i < k; i++) {
            agentList.get(i).add(0); //큐의 사이즈가 유형에 할당된 인원과 같다.
            recur(dep-1, i);
            agentList.get(i).poll();
        }
    }

}
