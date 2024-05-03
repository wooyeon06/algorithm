package test;

import util.P;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        String[] picture = new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        int k = 2;

        int len = picture.length;
        len = len * k;

        String[] answer = new String[len];

        int idx = 0;
        for(int i=0 ; i<picture.length ; i++ ) {

            String pic = picture[i];
            String newPic = "";
            for(int m=0 ; m<pic.length() ; m++ ) {
                String c = "" + pic.charAt(m);
                for(int n=0 ; n<k ; n++ ) {
                    newPic += c;
                }
            }


            for(int j=0 ; j<k ; j++ ) {
                answer[idx] = newPic;
                idx++;
            }
        }

        P.arr(answer);


    }


}


