package yandex.coderun.cbc2025.task7;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/first-seed-random-garden">task link</a><br>
 * test - OK
 */
public class Solution {
    long MOD = 1_000_000_000L - 7538L;
    Map<Long, Long> map = new HashMap<>();

    public long solve(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0L, 1L);
            return 1L;
        }

        long old2 = solve(n / 2);
        long old3 = solve(n / 3);
        long old4 = solve(n / 4);

        long c1 = powMod(old2, old3);
        long c2 = (5 * old4) % MOD;
        long c3 = n % MOD;

        long out = (c1 + c2 + c3) % MOD;

        map.put(n, out);

        return out;
    }

    long powMod(long b, long e) {
        long out = 1;
        b = b % MOD;

        while (e > 0) {
            if (e % 2 == 1) {
                out = (out * b) % MOD;
            }
            e = e / 2;
            b = (b * b) % MOD;
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(1));
        System.out.println(solution.solve(5));
        System.out.println(solution.solve(100));
    }
}
