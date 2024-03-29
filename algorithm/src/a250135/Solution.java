package a250135;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {

    boolean isLog = true;

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int s = s2 - s1;
        if (s < 0) {
            if (m2 == 0) {
                m2 = 60;
                h2--;
            }
            m2--;
        }

        int m = m2 - m1;
        if (m < 0) h2--;

        int h = h2 - h1;

        s = Math.abs(s);
        m = Math.abs(m);
        h = Math.abs(h);


        int S = h * 60 * 60 + m * 60 + s;
        int cnt = 0;
        ////////////////////////////////////////////////////////////////////////////////////

        double h_degree = (30*h1 + (m1/2d) + (s1/120d))%360;
        double m_degree = (m1*6 + (s1/10d))%360;
        double s_degree = (s1*6)%360;
        double ex_s_degree = s_degree;

        System.out.println("h_degree : " +  h_degree);
        System.out.println("m_degree : " +  m_degree);
        System.out.println("s_degree : " +  s_degree);
        System.out.println("========================================================");


        //초기값 체크
        if(h_degree==s_degree && m_degree==s_degree) {
            System.out.println("h_degree==s_degree==m_degree : " + m_degree);
            cnt++;

            ex_s_degree = s_degree;
            s_degree = (s_degree+6)%360;
            m_degree = (m_degree + (1/10d)) % 360;
            h_degree = (h_degree + (1/120d)) % 360;
        }

        //Double hDegree = (h % 12) * 30d + m*0.5d + s * (1/120d);
        int t = 1;
        for (int i = 0; i < S; i++) {
            ex_s_degree = s_degree;
            s_degree = (s_degree + 6) % 360;
            m_degree = (m_degree + (1d/10d)) % 360;
            h_degree = (h_degree + t*(1/120d)) % 360;

            //System.out.println("h_degree : " +  h_degree);
            System.out.println("m_degree : " +  m_degree);
            //System.out.println("s_degree : " +  s_degree);

            /*if(h_degree==s_degree && m_degree==s_degree) {
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
            }*/


        }


        return cnt;
    }
}