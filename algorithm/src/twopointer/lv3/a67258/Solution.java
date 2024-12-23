package twopointer.lv3.a67258;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {

        //new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}
        //3, 7
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        int[] answer = new int[2];

        HashMap<String, Integer> map = new HashMap();
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if(min > i-start && map.size() == kind) {
                min = i-start;
                answer[0] = start+1;
                answer[1] = i+1;
            }
        }



        return answer;
    }
}


