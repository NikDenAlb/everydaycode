package yandex.coderun.random.task162;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.function.IntPredicate;

/**
 * <a href="https://coderun.yandex.ru/problem/random-swaps">task link</a><br>
 * test - OK
 */
class RandomSwapsDouble {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        long n = Long.parseLong(s);
        int k = Integer.parseInt(reader.readLine());

        int l = s.length();
        GoodFilter goodFilter = new GoodFilter(n % 3 == 0);
        int gCnt = (int) s.chars().filter(goodFilter).count();

        double[] dp = new double[k + 1];
        dp[0] = (n % 5 == 0 || n % 6 == 0) ? 1 : 0;
        for (int i = 1; i <= k; i++) {
            dp[i] = (dp[i - 1] * (l * (l - 1) - 2 * l) + 2 * gCnt) / (l * (l - 1));
        }

        writer.write(String.format("%.15f", dp[k]));

        reader.close();
        writer.close();
    }

    static class GoodFilter implements IntPredicate {
        boolean isDiv3;

        GoodFilter(boolean isDiv3) {
            this.isDiv3 = isDiv3;
        }

        @Override
        public boolean test(int val) {
            int d = val - '0';
            if (isDiv3) {
                return d == 5 || d % 2 == 0;
            }
            return d == 5;
        }
    }
}
