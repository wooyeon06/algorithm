package util;

public class DP {


    public static void main(String args[]) {


        int n = 10; // 피보나치 수열의 원하는 길이
        System.out.println("피보나치 수열의 처음 " + n + "개 숫자:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        int DP[] = fibonacciDP(10);
        P.arr(DP);

    }



    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static int[] fibonacciDP(int n) {
        int DP[] = new int[n];
        DP[0] = 0;
        DP[1] = 1;

        for (int i = 2; i < DP.length; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        return DP;
    }


}
