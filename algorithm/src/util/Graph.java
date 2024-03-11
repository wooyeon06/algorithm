package util;

public class Graph {

    static int N = 1000000;

    public static void main(String args[]) {
        
        
        //1. in, out으로 보는 그래프
        int[][] edges = new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        int[] ingoing = new int[N];
        int[] outgoing = new int[N];

        for (int[] edge : edges) {
            outgoing[edge[0]]++;
            ingoing[edge[1]]++;
        }


        /////////////////////////////////////////////////////

    }


}
