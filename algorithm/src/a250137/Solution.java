package a250137;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;


        int n = attacks[attacks.length-1][0];

        int maxHealth = health;
        int aIndex = 0;
        int continuous = 0;
        for (int i = 0; i <= n; i++) {

            //몬스터 공격이 있음
            if(i==attacks[aIndex][0]) {

                //연속성 초기화
                continuous = 0;
                
                //체력까임
                health = health - attacks[aIndex][1];
                aIndex++;
                if(health <= 0) {
                    answer = -1;
                    break;
                }
            } else {
                continuous++;
                if(maxHealth > health) {
                    //초당회복량
                    health = bandage[1] + health;
                    
                    //추가회복
                    if(continuous  == bandage[0]) {
                        health = bandage[2] + health;
                        continuous = 0;
                    }
                }

                if(maxHealth < health)  health = maxHealth;
            }

            System.out.println("health : "+ health);

        };

        if(answer != -1) answer = health;
        return answer;
    }
}