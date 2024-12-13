package lv3.a72414;
import java.util.Arrays;

class Solution {
    public String solution(String play_time, String adv_time, String[] _logs) {
        int l_play_time = toIntTime(play_time);
        int l_adv_time  = toIntTime(adv_time);

        int[] dp = new int[l_play_time+1];
        for (int i = 0; i < _logs.length; i++) {
            String[] s = _logs[i].split("-")[0].split(":");
            String[] e = _logs[i].split("-")[1].split(":");
            int ss = toIntTime(_logs[i].split("-")[0]);
            int ee = toIntTime(_logs[i].split("-")[1]);
            for (int j = ss; j < ee; j++) {
                dp[j] = dp[j] + 1;
            }
        }

        int idx = 0;
        long total = 0;
        for (int i = 0; i < l_adv_time; i++) {
            total += dp[i];
        }
        long max = total;
        for (int i = l_adv_time; i < l_play_time; i++) {
            total = total + dp[i] - dp[i-l_adv_time];
            if(max < total) {
                max = total;
                idx = i-l_adv_time + 1;
            }

        }

        return toStrTime(idx);
    }

    int toIntTime(String strTime) {
        int[] HMS = Arrays.stream(strTime.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return 3600 * HMS[0] + 60 * HMS[1] + HMS[2];
    }

    String toStrTime(int time) {
        int H = time / 3600;
        int M = (time - 3600 * H) / 60;
        int S = time - 3600 * H - 60 * M;

        return (H < 10 ? "0" : "") + H + ":" +
                (M < 10 ? "0" : "") + M + ":" +
                (S < 10 ? "0" : "") + S;
    }
}