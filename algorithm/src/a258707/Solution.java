package a258707;

import util.P;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int round = 1;
    int[] cards;
    int[] cur;
    int n;
    int p;

    public int solution(int coin, int[] cards) {

        //3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4


        n = cards.length/3;
        p = cards.length + 1;
        this.cards = cards;

        cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = cards[i];
        }


        return 0;
    }


    public boolean changeCard(int[] cards, int card1, int card2) {
        for (int i = 0; i < n; i++) {
            if(card1) {

            }

            for (int j = i; j < n; j++) {
                if(cards[i]+cards[j] == p) {
                    cards[i] = card1;
                    cards[j] = card2;
                    return true;
                }
            }
        }
        return false;
    }



    public void recur(int i, ArrayList<Integer> cur, int round, int coin) {
        if(i>=cards.length) {
            return;
        }
    }


}