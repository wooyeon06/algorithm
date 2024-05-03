package lv3.a136797;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int L = 0;
    int R = 0;

    char[][] keypad;
    HashMap<Character, int[]> keymap = new HashMap<Character, int[]>();
    public int solution(String numbers) {

        keypad = new char[][] {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };

        keymap.put('1', new int[]{0,0});
        keymap.put('2', new int[]{0,1});
        keymap.put('3', new int[]{0,2});
        keymap.put('4', new int[]{1,0});
        keymap.put('5', new int[]{1,1});
        keymap.put('6', new int[]{1,2});
        keymap.put('7', new int[]{2,0});
        keymap.put('8', new int[]{2,1});
        keymap.put('9', new int[]{2,2});
        keymap.put('*', new int[]{3,0});
        keymap.put('0', new int[]{3,1});
        keymap.put('#', new int[]{3,2});
        ///////////////////////////////////////////////////////////////







        return 0;
    }


    public int distance(char a, char b) {

        int _a[] = keymap.get(a);
        int _b[] = keymap.get(b);

        int x = Math.abs(_a[0] - _b[0]);
        int y = Math.abs(_a[1] - _b[1]);

        if(x==0 && y==0) return 1;
        if(x==1 && y==0 || x==0 && y==1) return 2;
        if(x==1 && y==1) return 3;

        return 0;
    }

}