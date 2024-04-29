package lv3.a150366;


import java.util.*;

class Solution {

    Node[][] table;
    class Node {
        String value = "";
        HashSet<Node> mergeSet;
        public Node() {
            mergeSet = new HashSet<>();
        }
    }


    ArrayList<String> p = new ArrayList<String>();
    public String[] solution(String[] commands) {
        table = new Node[51][51];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = new Node();
            }
        }

        for (String c : commands) {

            String[] command = c.split(" ");

            if("UPDATE".equals(command[0])) {
                if(command.length == 4) {
                    update(Integer.valueOf(command[1]), Integer.valueOf(command[2]), command[3]); //특정 위치 update
                } else {

                    update(command[1], command[2]);//v1, v2로 update

                }
            } else if("MERGE".equals(command[0])) {

                int r1 = Integer.valueOf(command[1]);
                int c1 = Integer.valueOf(command[2]);

                int r2 = Integer.valueOf(command[3]);
                int c2 = Integer.valueOf(command[4]);

                merge(r1, c1, r2, c2);

            } else if("UNMERGE".equals(command[0])) {

                int r1 = Integer.valueOf(command[1]);
                int c1 = Integer.valueOf(command[2]);
                unmerge(r1, c1);

            } else if("PRINT".equals(command[0])) {

                int r1 = Integer.valueOf(command[1]);
                int c1 = Integer.valueOf(command[2]);
                p.add(print(r1, c1));
            }

        }



        printT();


        String[] answer = p.toArray(new String[0]);
        return answer;
    }

    public void update(int r, int c, String v) {
        table[r][c].value = v;
        if(table[r][c].mergeSet != null && table[r][c].mergeSet.size() > 0) {
            for (Node node : table[r][c].mergeSet) {
                node.value = v;
            }
        }
    }

    public void update(String v1, String v2) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(v1.equals(table[i][j].value)) {
                    table[i][j].value = v2;
                    if(table[i][j].mergeSet != null && table[i][j].mergeSet.size() > 0) {
                        for (Node node : table[i][j].mergeSet) {
                            node.value = v2;
                        }
                    }
                }
            }
        }
    }




    //////////////////////////////////////////////////////////////////////////////////////////////


    public void merge(int r1, int c1, int r2, int c2) {

        //2 1 1 1

        String v1 = table[r1][c1].value;
        String v2 = table[r2][c2].value;

        String v = "";
        if(v1 == null || "".equals(v1)) {
            v = v2;
        } else {
            v = v1;
        }

        if(table[r1][c1].mergeSet == null) table[r1][c1].mergeSet = new HashSet<Node>();
        if(table[r2][c2].mergeSet == null) table[r2][c2].mergeSet = new HashSet<Node>();


        table[r1][c1].mergeSet.add(table[r1][c1]);
        table[r1][c1].mergeSet.add(table[r2][c2]);
        table[r1][c1].mergeSet.addAll(table[r2][c2].mergeSet);

        table[r2][c2].mergeSet = table[r1][c1].mergeSet;


        //최종 값 변경
        Iterator iter = table[r1][c1].mergeSet.iterator();
        while(iter.hasNext()) {
            Node n = (Node) iter.next();
            n.mergeSet = table[r1][c1].mergeSet;
            n.value = v;
        }

    }



    public void unmerge(int r, int c) {
        Node n = table[r][c];
        String v = table[r][c].value;
        if(table[r][c].mergeSet!=null) {
            Iterator iter = table[r][c].mergeSet.iterator();
            while(iter.hasNext()) {
                Node _n = (Node) iter.next();
                _n.value = "";
                _n.mergeSet = null;
            }
        }


        n.mergeSet = null;
        n.value = v;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public String print(int r, int c) {
        String v = table[r][c].value;
        if(v==null || "".equals(v)) {
            return "EMPTY";
        }
        return v;
    }



    public void printT() {

        // 각 열의 최대 너비 계산
        int[] columnWidths = new int[table[0].length];
        for (Node[] row : table) {
            for (int j = 0; j < row.length; j++) {
                int width = String.valueOf(row[j].value).length();
                columnWidths[j] = Math.max(columnWidths[j], width);
            }
        }

        // 출력
        System.out.print("  |  ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-" + (columnWidths[i] + 5) + "s", i);
        }
        System.out.println();
        for (int i = 0; i < ((columnWidths[0]+5) * 10) ; i++) {
            System.out.print("ㅡ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |  ");
            for (int j = 0; j < 10; j++) {
                // 각 열의 값 출력 후 공백 삽입하여 간격 맞춤
                System.out.printf("%-" + (columnWidths[j] + 5) + "s", table[i][j].value);
            }
            System.out.println(); // 개행
        }
    }


}



