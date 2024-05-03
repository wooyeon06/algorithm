package lv3.a150365;

//d l r u 문자순서


class Solution {

    String temp;
    int n, m, k, r, c;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //S x, y     2~50
        //E r, c     2~50
        x--;
        y--;
        r--;
        c--;
        this.n = n;
        this.m = m;
        this.k = k;
        this.r = r;
        this.c = c;

        int length = distance(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";

        //d l r u 문자순서
        recur(0, x, y, "");

        return temp;
    }

    int[][] dir = new int[][]{{1,0}, {0, -1}, {0, 1}, {-1, 0}};
    public void recur(int depth, int r, int c, String s) {
        if(temp!=null) return;
        if(depth + distance(r, c, this.r, this.c) > k) return; //현재 깊이 + 남은 거리 > k
        if(k == depth) {
            temp = s;
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int _r = r + dir[i][0];
            int _c = c + dir[i][1];
            if(_r >= 0 && _c >= 0 && _r < n && _c < m) {
                if(i==0) recur(depth+1, _r, _c, s+"d");
                if(i==1) recur(depth+1, _r, _c, s+"l");
                if(i==2) recur(depth+1, _r, _c, s+"r");
                if(i==3) recur(depth+1, _r, _c, s+"u");
            }
        }
    }


    private int distance(int x, int y, int r, int c){
        return (int)Math.abs(x-r) + (int)Math.abs(y-c);
    }


}