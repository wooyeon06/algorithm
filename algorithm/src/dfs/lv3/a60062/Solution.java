package dfs.lv3.a60062;

class Solution {

    int[] weak2;
    boolean[] used;
    int[] dist;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        used = new boolean[dist.length];
        weak2 = new int[weak.length*2];
        for (int i = 0; i < weak.length; i++) {
            weak2[i] = weak[i];
            weak2[i + weak.length] = weak[i] + n;
        }

        //weak2 = [1, 5, 6, 10, 13, 17, 18, 22]
        for (int i = 0; i < weak.length; i++) {
            recur(i, 0, new int[dist.length]);
        }

        if(answer==Integer.MAX_VALUE) return -1;
        return answer;
    }
    //4 3 2 1
    public void recur(int start, int depth, int[] arr) {

        if(depth == dist.length) {
            int cnt = 1;
            int j=0;
            int pos = weak2[start] + arr[j];
            for (int i = start; i < (start + weak2.length/2); i++) {
                if(weak2[i] > pos) {
                    cnt++; //친구카운트
                    if (cnt > arr.length) {
                        cnt = Integer.MAX_VALUE;
                        break;
                    }
                    pos = weak2[i] + arr[++j];
                }
            }

            if(answer > cnt) answer = cnt;

        } else {
            for (int i = used.length-1; i >= 0; i--) {
                if(used[i]) continue;

                used[i] = true;
                arr[depth] = dist[i];
                recur(start, depth+1, arr);
                used[i] = false;
            }
        }
    }

}