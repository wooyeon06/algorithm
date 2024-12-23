package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {

    public static List<Integer> findPrimes(int n) {
        // 소수 여부를 표시하는 배열 생성
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // 2부터 시작해서 각 숫자의 배수를 제거
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) isPrime[j] = false;
            }
        }
        // 소수만 리스트에 추가
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 50; // 50 이하의 소수를 구함
        List<Integer> primes = findPrimes(n);

        System.out.println("Primes up to " + n + ": " + primes);
    }
}

