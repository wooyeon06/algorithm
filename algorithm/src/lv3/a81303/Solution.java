package lv3.a81303;

import java.util.Stack;

class Solution {

    public static class Node {
        Node prev;
        Node next;
        boolean used = true;
    }

    public String solution(int n, int k, String[] cmds) {

        Node[] node = new Node[n];
        Stack<Node> s = new Stack();
        for (int i = 0; i < n; i++) {
            node[i] = new Node();
            if(i==0) continue;
            node[i].prev = node[i-1];
            node[i-1].next = node[i];
        }


        Node cur = node[k];
        for (String cmd : cmds) {
            //현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
            if("C".equals(cmd)) {
                s.push(cur);
                cur.used = false;
                Node prev = cur.prev;
                Node next = cur.next;

                if(prev!=null){
                    prev.next=next;
                }
                if(next!=null){
                    next.prev=prev;
                }

                if(next != null) {
                    cur = next;
                } else {
                    cur = prev;
                }

            } else if(cmd.indexOf("U") > -1) {
                int move = Integer.valueOf(cmd.split(" ")[1]);
                for (int i = 0; i < move; i++) {
                    cur = cur.prev;
                }
            } else if(cmd.indexOf("D") > -1) {
                int move = Integer.valueOf(cmd.split(" ")[1]);
                for (int i = 0; i < move; i++) {
                    cur = cur.next;
                }
            } if("Z".equals(cmd)) {
                Node z = s.pop();
                z.used = true;
                Node prev = z.prev;
                Node next = z.next;

                if(prev != null) {
                    prev.next = z;
                }
                if(next != null) {
                    next.prev = z;
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for(Node c : node) {
            if(c.used) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }
}










/* 효율성 6,7,8,9,10실패

public String solution(int n, int k, String[] cmds) {

        Stack<Integer> removeList = new Stack<>();
        Stack<String> stack = new Stack<>();

        String[] arr = new String[n];
        Arrays.fill(arr, "O");

        *//*
        "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
        "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
        "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
        "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
         *//*


        //P.arr(cmds);

        for (String cmd : cmds) {

            if("C".equals(cmd)) {
                arr[k] = "X";
                removeList.push(k);
                int idx = -1;
                //아래로
                for (int i = k+1; i < n; i++) {
                    if("O".equals(arr[i])) {
                        idx = i;
                        break;
                    }
                }
                /////////////////////////////////
                if(idx != -1) {
                    k = idx;
                } else {
                    //아래에 없다면 위로
                    for (int i = k-1; i > -1; i--) {
                        if("O".equals(arr[i])) {
                            k = i;
                            break;
                        }
                    }
                }
            }else if(cmd.indexOf("U") > -1) {
                int move = Integer.valueOf(cmd.split(" ")[1]);
                for (int i = k-1; i > -1; i--) {
                    if("O".equals(arr[i])) {
                        move--;
                    }
                    if(move == 0) {
                        k = i;
                        break;
                    }
                }
            }else if(cmd.indexOf("D") > -1) {
                int move = Integer.valueOf(cmd.split(" ")[1]);
                for (int i = k+1; i < n; i++) {
                    if("O".equals(arr[i])) {
                        move--;
                    }
                    if(move == 0) {
                        k = i;
                        break;
                    }
                }
            }else if("Z".equals(cmd)) {
                arr[removeList.pop()] = "O";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        return sb.toString();
    }*/