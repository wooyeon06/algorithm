package test;

import util.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        String str_list[] = new String[]{"u", "u", "u", "r", "u"};

        String[] answer = {};

        int idx = 0;
        String s = "";
        for(int i=0 ; i<str_list.length ; i++) {

            if(str_list[i].equals("l") || str_list[i].equals("r")) {
                idx = i;
                s = str_list[i];
                break;
            }

        }

        if("l".equals(s)) {
            answer = Arrays.copyOfRange(str_list, 0, idx);
        } else {
            answer = Arrays.copyOfRange(str_list, idx+1, str_list.length);
        }


        P.arr(answer);

    }


}
