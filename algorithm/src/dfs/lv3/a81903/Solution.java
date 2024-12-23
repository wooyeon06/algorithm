package dfs.lv3.a81903;

import java.util.Arrays;
import java.util.HashSet;
class Solution {

    String[] user_id;
    String[] banned_id;
    HashSet<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        recur(0, new int[user_id.length]);
        return set.size();
    }

    public void recur(int idx, int[] flag) {
        if(idx == banned_id.length) {
            set.add(Arrays.toString(flag));
        } else {
            for (int i = 0; i < user_id.length; i++) {
                if(flag[i] == 1) continue;

                if(equals(banned_id[idx], user_id[i])) {
                    flag[i] = 1;
                    recur(idx + 1, flag);
                    flag[i] = 0;
                }
            }
        }
    }

    public boolean equals(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i) || s1.charAt(i) == '*' || s2.charAt(i) == '*') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}

