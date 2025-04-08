package sort.lv3.a250121;

import java.util.ArrayList;

class Solution2 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int type = 0;
        //"code", "date", "maximum", "remain"
        if("code".equals(ext)) {
            type = 0;
        }
        else if("date".equals(ext)) {
            type = 1;
        }
        else if("maximum".equals(ext)) {
            type = 2;
        }
        else if("remain".equals(ext)) {
            type = 3;
        }

        int stype = 0;
        //"code", "date", "maximum", "remain"
        if("code".equals(sort_by)) {
            stype = 0;
        }
        else if("date".equals(sort_by)) {
            stype = 1;
        }
        else if("maximum".equals(sort_by)) {
            stype = 2;
        }
        else if("remain".equals(sort_by)) {
            stype = 3;
        }



        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < data.length; i++) {
            if(data[i][type] < val_ext) {
               list.add(data[i]);
            }
        }

        int[][] answer = new int[list.size()][data[0].length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        int n = answer.length;
        for(int i=n-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                //오름
                int[] temp;
                System.out.println(answer[j+1][stype]);
                if(answer[j+1][stype] < answer[j][stype]) {
                    temp  = answer[j+1];
                    answer[j+1] = answer[j];
                    answer[j] = temp;
                }
            }
        }


        return answer;
    }
}