package a214289;

class Solution2 {

    int a, b, i, add, t, n, t1, t2, min = 1000000000;
    int[] onboard;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

        //-10 ≤ temperature ≤ 40

        this.onboard = onboard;
        this.a = a;
        this.b = b;
        this.n = onboard.length;
        this.t1 = t1;
        this.t2 = t2;

        //t에 가까워저야함
        if(temperature < t1) {
            add = 1;
        }
        if(temperature > t2) {
            add = -1;
        }


        //첫 희망온도 설정
        //for (int i = -10; i <= 40; i++) {
        //    t = i;
            t=8;
            recur(0,0,0,temperature);
        //}

        return min;
    }


    //on 1  off 0
    public void recur(int capacity, int on, int i, int temperature) {
        if(i>=n || capacity >= min) {
            if(min > capacity) {
                min = capacity;
                System.out.println("capacity : " + capacity + "  temperature : " + temperature);
            }
            return;
        }


        if(onboard[i] == 1) {
            //실내가 현재 온도 범위안
            if(t1<temperature && temperature<t2) {
            } else if(t1==temperature || temperature==t2) {
                //on
                if (t == temperature) {
                    recur(capacity + b, 1, i + 1, temperature);
                } else {
                    recur(capacity + a, 1, i + 1, temperature + add);
                }
                return;
            } else {
                return;
            }
        }


        //on
        if (t == temperature) {
            recur(capacity + b, 1, i + 1, temperature);
        } else {
            recur(capacity + a, 1, i + 1, temperature + add);
        }

        //off
        recur(capacity, 1, i + 1, temperature - add);

    }

}