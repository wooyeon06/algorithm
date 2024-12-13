package lv3.a76503;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public class Node {
        long weight = 0;
        ArrayList<Node> con = new ArrayList<>();
    }


    public long solution(int[] a, int[][] edges) {

        Node[] nodes = new Node[a.length];
        for (int i = 0; i < edges.length; i++) {
            if(nodes[edges[i][0]] == null) nodes[edges[i][0]] = new Node();
            if(nodes[edges[i][1]] == null) nodes[edges[i][1]] = new Node();

            nodes[edges[i][0]].con.add( nodes[edges[i][1]] );
            nodes[edges[i][1]].con.add( nodes[edges[i][0]] );
        }

        Queue<Node> q = new LinkedList();
        for (int i = 0; i < a.length ; i++) {
            nodes[i].weight = a[i];
            if(nodes[i].con.size() == 1) q.add(nodes[i]);
        }

        long answer = -1L;
        long sum = 0L;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.con.size() == 0) {
                if(cur.weight == 0) {
                    answer = sum;
                }
                break;
            } else {
                Node next = cur.con.get(0);
                next.weight += cur.weight;
                sum += Math.abs(cur.weight);

                next.con.remove(cur);
                cur.con.remove(next);

                if(next.con.size() == 1) q.add(next);
            }
        }


        return answer;
    }
}