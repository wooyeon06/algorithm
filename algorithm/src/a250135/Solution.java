package a250135;


class Solution {

    boolean isLog = false;

    int h1;
    int m1;
    int s1;

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        this.h1 = h1;
        this.m1 = m1;
        this.s1 = s1;


        int S = calculateTimeDifferenceInSeconds(h1, m1, s1, h2, m2, s2);
        int cnt = 0;
        if (isLog) {
            System.out.println("S : " + S);
        }

        ////////////////////////////////////////////////////////////////////////////////////
        double h_degree = getHDegree(0);
        double m_degree = getMDegree(0);
        double s_degree = getSDegree(0);
        double ex_s_degree = s_degree;


        //초기값 체크
        int idx = 1;
        if (h_degree == s_degree && m_degree == s_degree) {
            if (isLog) System.out.println("시0 == 분 0 ==초0");
            cnt++;
        }

        for (int i = idx; i <= S; i++) {
            ex_s_degree = getSDegree(i - 1);
            s_degree = getSDegree(i);
            m_degree = getMDegree(i);
            h_degree = getHDegree(i);

            if (isLog) {
                //System.out.println("s_degree : " + s_degree);
                //System.out.println("m_degree : " + m_degree);
                //System.out.println("h_degree : " + h_degree);
            }
            if (h_degree == s_degree && m_degree == s_degree) {
                if (isLog) System.out.println("시0 == 분 0 ==초0");
                cnt++;
            } else {


                //System.out.println("m_degree : " + m_degree + " , " + "t_s_degree : " + t_s_degree);

                double t_s_degree = s_degree;
                if (s_degree == 0) t_s_degree = 360;

                if ((ex_s_degree == 0 && getHDegree(i - 1) == 0)) {
                    continue;
                } else if(h_degree == s_degree) {
                    if (isLog) System.out.println("시 == 초");
                    cnt++;
                } else if (ex_s_degree < h_degree && h_degree < t_s_degree) {
                    if (isLog) System.out.println(ex_s_degree + " < h_degree (" + h_degree + ") < " + t_s_degree);
                    cnt++;
                }


                if ((ex_s_degree == 0 && getMDegree(i - 1) == 0)) {
                    continue;
                } else if(m_degree == s_degree) {
                    if (isLog) System.out.println("분 == 초");
                    cnt++;
                } else if ((ex_s_degree < m_degree && m_degree < t_s_degree)) {
                    if (isLog) System.out.println(ex_s_degree + " < m_degree (" + m_degree + ") < " + t_s_degree);
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public double getHDegree(int s) {
        return (30 * (h1 % 12) + (m1 / 2d) + (s1 + s) * (1 / 120d)) % 360;
    }

    public double getMDegree(int s) {
        return (m1 * 6 +  (s1 + s) * (1 / 10d)) % 360;
    }

    public double getSDegree(int s) {
        return (s1 * 6 + s * 6) % 360;
    }

    public static int calculateTimeDifferenceInSeconds(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시분초를 초로 변환하여 계산
        int time2InSeconds = s2 + m2 * 60 + h2 * 3600;
        int time1InSeconds = s1 + m1 * 60 + h1 * 3600;

        // 두 시간의 차이 계산
        return time2InSeconds - time1InSeconds;
    }

}