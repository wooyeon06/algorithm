package a250135;

public class Test2 {
    static final int CLOCK_LENGTH = 43200;

    // a가 b를 한 단위시간 지났다고 가정했을때 추월했는가?
    public boolean isOver(int aPos, int bPos, int aSpeed, int bSpeed){

        int beforeAPos = aPos-aSpeed < 0? aPos-aSpeed+CLOCK_LENGTH : aPos-aSpeed;
        int beforeBPos = bPos-bSpeed < 0? bPos-bSpeed+CLOCK_LENGTH : bPos-bSpeed;

        aPos = beforeAPos + aSpeed;
        bPos = beforeBPos + bSpeed;

        if(beforeAPos < beforeBPos && aPos > bPos){
            return true;
        }
        return false;

    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        // 주어진 시간을 가지고, 시침,분침,초침의 상대적 위치를 정한다.
        int hPos, mPos, sPos;


        // 각 침의 위치는 0:00:00부터 시작하여, 시간이 얼마나 흘렀나를 가지고 구할 수 있다.
        int time = 3600*h1+60*m1+s1;

        hPos = (time % CLOCK_LENGTH);

        mPos = ((time*12) % CLOCK_LENGTH);

        sPos = ((time*720) % CLOCK_LENGTH);

        int endTime = 3600*h2+60*m2+s2;

        while(true){

            // 일치하는 경우
            if(sPos == mPos) answer++;
            if(sPos == hPos) answer++;

            // 시분초가 나란히 한 줄일 때 알람이 한번만 울려야 한다.
            if(time == CLOCK_LENGTH || time == 0){
                answer--;
            }

            // 시간을 땡긴다.
            if(++time > endTime) break;

            sPos = (sPos + 720) % CLOCK_LENGTH;
            mPos = (mPos + 12) % CLOCK_LENGTH;
            hPos = (hPos + 1) % CLOCK_LENGTH;

            // 초침이 분침을 초월했는가?
            if(isOver(sPos,mPos,720,12)) answer++;
            if(isOver(sPos,hPos,720,1)) answer++;

        }

        return answer;
    }
}