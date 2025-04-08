package sort.lv3.a250121;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        PriorityQueue<int[]> pq = null;
        int type = 0;
        //"code", "date", "maximum", "remain"
        switch (ext) {
            case "code" :
                type = 0; break;
            case "date" :
                type = 1; break;
            case "maximum" :
                type = 2; break;
            case "remain" :
                type = 3;  break;
        }
        switch (sort_by) {
            case "code" :
                pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); break;
            case "date" :
                pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); break;
            case "maximum" :
                pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); break;
            case "remain" :
                pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[3])); break;
        }

        for (int i = 0; i < data.length; i++) {
            if(data[i][type] < val_ext)  pq.add(data[i]);
        }

        int [][] result = new int[pq.size()][4];
        int i=0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll(); // 우선순위 순서대로 꺼냄
        }
        return result;
    }
}