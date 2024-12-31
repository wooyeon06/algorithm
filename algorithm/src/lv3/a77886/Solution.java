package lv3.a77886;

import java.util.Stack;

class Solution {
    String x = "110";
    public String[] solution(String[] in) {
        //["1110","100111100","0111111010"]
        //["1101","100110110","0110110111"]
        String[] answer = new String[in.length];
        int idx = 0;


        for(String s : in) {
            int cnt = 0;
            StringBuffer sb = new StringBuffer();
            long min = Long.MAX_VALUE;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if('1' == s.charAt(i)) {
                    stack.push('1');
                } else {
                    if(stack.size() >= 2) {
                        char one = stack.pop();
                        char two = stack.pop();
                        if (one == '1' && two == '1') {
                            sb.append(x);
                        } else {
                            stack.push(two);
                            stack.push(one);
                            stack.push('0');
                        }
                    } else {
                        stack.push('0');
                    }
                }
            }

            StringBuilder strBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                strBuilder.insert(0, stack.pop());
            }
            String str = strBuilder.toString();



            /*int start;
            while((start = s.indexOf(x)) > -1) {
                int end = start + 3;
                s = s.substring(0, start) + s.substring(end, s.length());
                sb.append(x);
            }*/

            int lastIndexOf = str.lastIndexOf("0") + 1;
            answer[idx] = str.substring(0, lastIndexOf) + sb.toString() + str.substring(lastIndexOf, str.length());
            idx++;
        }
        return answer;
    }



}