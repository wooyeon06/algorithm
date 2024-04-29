package copy;

import util.P;

import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};

        //3	[1, 5, 2]	[1, 2, 3, 4, 5, 6, 7, 8, 9]	[2, 3, 4, 5, 6]

        /*
        n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
        n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
        n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
        n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
         */



        switch (n) {

            case 1:
                answer = Arrays.copyOfRange(num_list, 0, slicer[1]+1);
                break;
            case 2:
                answer = Arrays.copyOfRange(num_list, slicer[0], num_list.length);
                break;
            case 3:
                answer = Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
                break;
            case 4:
                ArrayList<Integer> list = new ArrayList();
                for (int i = slicer[0]; i <= slicer[1] ; i=i+slicer[2]) {
                    list.add(num_list[i]);
                }

                answer = list.stream().mapToInt(Integer::intValue).toArray();
                break;
        }




        P.arr(answer);


        return answer;
    }
}