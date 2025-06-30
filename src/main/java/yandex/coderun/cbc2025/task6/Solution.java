package yandex.coderun.cbc2025.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/choose_primes">task link</a><br>
 * test - OK
 */
public class Solution {
    public long solve(int n) {
        List<Integer> primes = findPrimes(n);
        if (primes.size() < 2) {
            return 0;
        }
        int mod1 = 0;
        int mod3 = 0;
        for (int e : primes) {
            if (e % 4 == 1) {
                mod1++;
            } else if (e % 4 == 3) {
                mod3++;
            }
        }
        return (long) mod1 * mod3;
    }

    List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 3; num <= n; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(3));
        System.out.println(solution.solve(5));
        System.out.println(solution.solve(7));
    }
}