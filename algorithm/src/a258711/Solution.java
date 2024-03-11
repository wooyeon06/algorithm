package a258711;

class Solution {
    static int N = 1000000;

    public int[] solution(int[][] edges) {
        int[] ingoing = new int[N];
        int[] outgoing = new int[N];

        for (int[] edge : edges) {
            outgoing[edge[0]]++;
            ingoing[edge[1]]++;
        }

        int created = 0;
        int eight = 0;
        int stick = 0;

        for (int i = 1; i < N; i++) {
            if (outgoing[i] >= 2) {
                if (ingoing[i] == 0) { //나가는선 2개이상 들어오는건 없음
                    created = i;
                } else {  //8자그래프
                    eight++;
                }
            } else if (outgoing[i] == 0 && ingoing[i] > 0) { //나가는게 없고 , 들어오는게 1개이상 >  1자 그래프
                stick++;
            }
        }


        return new int[]{created, outgoing[created] - eight - stick, stick, eight};
    }
}
