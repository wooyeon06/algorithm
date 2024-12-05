package lv3.a77486;

import util.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public class Node {
        Node parents;
        String name = "";
        int amont = 0;
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> map = new HashMap<>();
        Node root = new Node();
        root.name = "-";
        map.put("-", root);
        for (int i = 0; i < enroll.length; i++) {
            Node node = new Node();
            Node parents = map.get(referral[i]);
            node.parents = parents;

            map.put(enroll[i], node);
            node.name = enroll[i];
        }


        for (int i = 0; i < seller.length; i++) {
            Node node = map.get(seller[i]);
            int v = amount[i] * 100;
            if(node.parents != null) {
                recur(node, v);
            } else {
                node.amont += v;
            }
        }

        int answer[] = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).amont;
        }
        return answer;
    }


    public void recur(Node n, int v) {
        if(v < 10 || n.parents == null) {
            n.amont += v;
        } else {
            int v10 = v / 10;
            n.amont += (v - v10);
            recur(n.parents, v10);
        }
    }

}