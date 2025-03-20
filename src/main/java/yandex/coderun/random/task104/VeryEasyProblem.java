package yandex.coderun.random.task104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
f=min(x.y)
k - time after f
n--;
n<=k/x+k/y+{0...-x-y+2}
nxy<=ky+kx
k>=nxy/(x+y)
k>=(n+x+y-2)xy/(x+y)
*/
/**
 * <a href="https://coderun.yandex.ru/problem/very-easy-problem">task link</a><br>
 * test - OK
 */
public class VeryEasyProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        long n = Integer.parseInt(input[0]);
        long x = Integer.parseInt(input[1]);
        long y = Integer.parseInt(input[2]);

        writer.write(String.valueOf(findMinTime(n, x, y)));

        reader.close();
        writer.close();
    }

    static long findMinTime(long n, long x, long y) {
        n--;
        long l = (n * x * y + x + y - 1) / (x + y);
        long r = ((n + x + y - 2) * x * y + x + y - 1) / (x + y);

        while (l < r) {
            long m = (l + r) / 2;
            if ((m / x + m / y) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (r + Math.min(x, y));
    }
}
