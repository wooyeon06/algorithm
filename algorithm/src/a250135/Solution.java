package a250135;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {

    boolean isLog = true;

    int h1;
    int m1;
    int s1;
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        this.h1 = h1;
        this.m1 = m1;
        this.s1 = s1;

        int s = s2 - s1;
        if (s < 0) {
            if (h2-h1 > 0 && m2 == 0) {
                m2 = 60;
                h2--;
            }
            m2--;
            s = 60 -s1;
        }

        int m = m2 - m1;
        if (m < 0) h2--;

        int h = h2 - h1;

        s = Math.abs(s);
        m = Math.abs(m);
        h = Math.abs(h);


        int S = h * 60 * 60 + m * 60 + s;
        System.out.println(h);
        System.out.println(m);
        System.out.println(s);
        int cnt = 0;
        ////////////////////////////////////////////////////////////////////////////////////

        double h_degree = getHDegree(0);
        double m_degree = (m1*6 + (s1/10d))%360;
        double s_degree = (s1*6)%360;
        double ex_s_degree = s_degree;

        System.out.println("h_degree : " +  h_degree);
        System.out.println("m_degree : " +  m_degree);
        System.out.println("s_degree : " +  s_degree);
        System.out.println("========================================================");


        //초기값 체크
        int idx = 1;
        if(h_degree==s_degree && m_degree==s_degree) {
            System.out.println("h_degree==s_degree==m_degree : " + m_degree);
            idx++;
            cnt++;
        }

        System.out.println(S);
        for (int i = idx; i <= S; i++) {
            ex_s_degree = getSDegree(i-1);
            s_degree = getSDegree(i);
            m_degree = getMDegree(i);
            h_degree = getHDegree(i);

            System.out.println("h_degree : " +  h_degree);
            System.out.println("m_degree : " +  m_degree);
            System.out.println("s_degree : " +  s_degree);
            System.out.println("ex_s_degree : " +  ex_s_degree);


            if(h_degree==s_degree && m_degree==s_degree) {
                System.out.println("h_degree==s_degree==m_degree : " + m_degree);
                cnt++;
            } else {
                if(ex_s_degree <= h_degree && h_degree <= s_degree) {
                    System.out.println("h_degree : " +   ex_s_degree + "<=" + h_degree + "<=" +s_degree);
                    cnt++;
                }
                if(ex_s_degree <= m_degree && m_degree <= s_degree) {
                    System.out.println("m_degree : " +   ex_s_degree + "<=" + m_degree + "<=" +s_degree);
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public double getHDegree(int s) {
        return (30*h1 + (m1/2d) + (s1/120d)  + s*(1/120d))%360;
    }

    public double getMDegree(int s) {
        return (m1*6 + (s1/10d) +  s*(1/10d))%360;
    }

    public double getSDegree(int s) {
        return (s1*6 + s*6)%360;
    }

}