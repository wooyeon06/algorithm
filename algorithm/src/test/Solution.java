package test;

class Solution {
    public String solution(String code) {
        //abc1abc1abc
        String answer = "";

        int mode = 0;
        for (int i = 0; i < code.length(); i++) {

            char c = code.charAt(i);
            if(c == '1') {
               mode = mode==0 ? 1 : 0;
               continue;
            }

            if(mode == 0) {
                if(i%2==0) answer = answer + c;
            } else if(mode == 1) {
                if(i%2!=0) answer = answer + c;
            }

        }

        if(answer.length() == 0) {
            return "EMPTY";
        }

        return answer;
    }
}