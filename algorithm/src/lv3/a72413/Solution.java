package lv3.a72413;


import util.P;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int N;
    int[][] weight;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        //6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
        //n은 3 이상 200
        //82
        this.N = n+1;
        weight = new int[N][N];
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            weight[fare[0]][fare[1]] = fare[2];
            weight[fare[1]][fare[0]] = fare[2];
        }

        int[] ab = dijkstra(s);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) { //같이 i까지 이동 > 이후 따로 이동
            int[] each = dijkstra(i);
            int cost = ab[i] + each[a] + each[b]; // i까지 같이  + i~a까지 따로 + i~b까지 따로
            min = Math.min(cost, min);
        }
        return min;
    }


    public int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visit = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new int[]{0, start}); //비용0

        while(!pq.isEmpty()) {
            int cur = pq.poll()[1];
            if (visit[cur]) continue;
            visit[cur] = true;
            for (int next = 1; next < N; next++) {
                if(weight[cur][next] == 0) continue;

                if (distance[cur] + weight[cur][next] < distance[next]) {
                    distance[next] = distance[cur] + weight[cur][next];
                    pq.add(new int[]{distance[next], next});
                }
            }
        }

        return distance;
    }

}

//1. 플로이드 워셜
/*import java.util.Arrays;

class Solution {
    static final int MAX = 20000001; // 200 * 100000 + 1
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], MAX);
            dp[i][i] = 0;
        }

        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }


        int answer = dp[s][a] + dp[s][b];
        // 경유지점을 끼는경우
        // s -> t t -> a + t -> b
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] +dp[i][b]);
        }
        return answer;
    }
}*/

/*
class Solution {

    public class Node {
        int id;
        ArrayList<Node> next = new ArrayList<>();
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        //6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
        //n은 3 이상 200
        //82

        Node[] node = new Node[n+1];
        int[][] weight = new int[n+1][n+1];
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            if(node[fare[0]]==null) {
                node[fare[0]] = new Node();
                node[fare[0]].id = fare[0];
            }
            if(node[fare[1]]==null) {
                node[fare[1]] = new Node();
                node[fare[1]].id = fare[1];
            }

            node[fare[0]].next.add(node[fare[1]]);
            node[fare[1]].next.add(node[fare[0]]);
            weight[fare[0]][fare[1]] = fare[2];
            weight[fare[1]][fare[0]] = fare[2];
        }


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s, s, 0, 0, 0}); //a, b, weight, prev a, prev b

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[2] > min) continue;

            if(cur[0] == a && cur[1] == b) {
                if(min > cur[2]) min = cur[2];
                System.out.println("{"+cur[0]+","+cur[1]+"} : " + cur[2]);
            } else {
                for(Node nextA : node[cur[0]].next) { // a
                    for(Node nextB : node[cur[1]].next) { // b
                        if(nextA.equals(nextB)) { //a, b 같이 이동
                            if(cur[0] != a  && cur[1] != b) {
                                if(nextA.id == cur[3] || nextB.id == cur[4]) continue;
                                q.add(new int[] {nextA.id, nextB.id, cur[2] + weight[cur[0]][nextA.id], cur[0], cur[1]});
                            }
                        } else { //a, b 따로이동
                            if(cur[0] == a) { //b만 이동
                                if(nextB.id == cur[4]) continue;
                                q.add(new int[] {a, nextB.id, cur[2] + weight[cur[1]][nextB.id], cur[0], cur[1]});
                            } else if(cur[1] == b) { //a만 이동
                                if(nextA.id == cur[3]) continue;
                                q.add(new int[] {nextA.id, b, cur[2] + weight[cur[0]][nextA.id], cur[0], cur[1]});
                            } else {
                                if(nextA.id == cur[3] || nextB.id == cur[4]) continue;
                                q.add(new int[] {nextA.id, nextB.id, cur[2] + weight[cur[0]][nextA.id] + weight[cur[1]][nextB.id], cur[0], cur[1]});
                            }
                        }
                    }
                }
            }
        }


        return min;
    }
}*/
