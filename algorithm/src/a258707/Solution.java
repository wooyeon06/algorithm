package a258707;

import java.util.ArrayList;

class Solution {

    int round = 1;
    int[] cards;
    ArrayList<Integer> cur = new ArrayList<Integer>();
    int n;
    int p;

    int max = 0;

    public int solution(int coin, int[] cards) {

        //3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4


        n = cards.length/3;
        p = cards.length + 1;
        this.cards = cards;
        for (int i = 0; i < n; i++) {
            cur.add(cards[i]);
        }

        recur(n, cur, 1, coin);
        return max;
    }

    public boolean removeCard(ArrayList<Integer> cur) {

        for (int i = 0; i < cur.size(); i++) {
            int a = cur.get(i);
            for (int j = i+1; j < cur.size() ; j++) {
                int b = cur.get(j);
                if(a+b == p) {
                    cur.remove(i);
                    cur.remove(j-1);
                    return true;
                }
            }
        }

        return false;
    }

    public void recovery(ArrayList<Integer> target, ArrayList<Integer> backup) {
        target.clear();
        target.addAll(backup);
    }


    public void recur(int i, ArrayList<Integer> cur, int round, int coin) {
        ArrayList<Integer> backup = new ArrayList<>(cur);

        if (round > max) {
            max = round;
        }


        if(i >= cards.length || cur.size() == 0) {
            return;
        }

        //코인 0개
        if(removeCard(cur)) {
            recur(i+2, cur, round+1, coin);
        }

        //코인 1개
        if(coin > 0) {
            recovery(cur, backup);
            cur.add(cards[i]);
            if(removeCard(cur)) {
                recur(i+2, cur, round+1, coin -1);
            }

            recovery(cur, backup);
            cur.add(cards[i+1]);
            if(removeCard(cur)) {
                recur(i+2, cur, round+1, coin -1);
            }
        }


        //코인 2개
        if(coin > 1) {
            recovery(cur, backup);

            cur.add(cards[i]);
            cur.add(cards[i+1]);
            if (removeCard(cur)) {
                recur(i+2, cur, round+1, coin - 2);
            }
        }


    }
}

/*
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean[] used;
    private int coin;
    private boolean canNext = true;

    public int solution(int coin, int[] cards) {
        List<Integer> list = new ArrayList<>();
        used = new boolean[cards.length];
        this.coin = coin;

        for (int i = 0; i < cards.length / 3; i++) {
            list.add(cards[i]);
        }

        int round = 1;

        for (int i = cards.length / 3; i < cards.length; i += 2) {
            list.add(cards[i]);
            list.add(cards[i + 1]);
            submit(list, cards.length + 1, cards);

            if (this.coin < 0 || !canNext) {
                return round;
            }

            round++;
        }

        return round;
    }

    private void submit(List<Integer> list, int n, int[] cards) {
        for (int i = 0; i < cards.length / 3; i++) {
            for (int j = i + 1; j < cards.length / 3; j++) {
                if (list.get(i) + list.get(j) == n && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    return;
                }
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == n && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    if (i >= cards.length / 3) {
                        coin--;
                    }
                    if (j >= cards.length / 3) {
                        coin--;
                    }
                    return;
                }
            }
        }

        canNext = false;
    }
}
* */
