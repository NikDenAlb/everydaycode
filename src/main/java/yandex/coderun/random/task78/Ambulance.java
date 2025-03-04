package yandex.coderun.random.task78;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/ambulance">task link</a><br>
 * test - OK
 */
public class Ambulance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        long k1 = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);
        long k2 = Long.parseLong(input[2]);
        long p2 = Long.parseLong(input[3]);
        long n2 = Long.parseLong(input[4]);

        writer.write(findAddress(k1, m, k2, p2, n2));

        reader.close();
        writer.close();
    }

    static String findAddress(long k1, long m, long k2, long p2, long n2) {
        long p1 = -1;
        long n1 = -1;

        if (m < n2 || k2 < ((p2 - 1) * m) + n2) {
            return p1 + " " + n1;
        }
    /*
    p                           1                               ||                          2                               ||
    n           1       |          2        |          3        ||          1       |          2        |           3       ||
    k   1   2   3   4   |   5   6   7   8   |   9   10  11  12  ||  13  14  15  16  |   17  18  19  20  |   21  22  23  24  ||
        -   -   -   -   |   -   -   -   -   |   -   -   -   -   ||  -   -   -   -   |   -   -   -   -   |   -   -   -   -   ||

    mq(p-1)<k<=mqp
    >>> q<k/(m(p-1))
    >>> q>=k/(mp)

    mq(p-1)+q(n-1)<k<=mq(p-1)+qn
    >>> q<k/(m(p-1)+n-1)
    >>> q>=k/(m(p-1)+n)
    */
        long minQ = (k2 + m * (p2 - 1) + n2 - 1) / (m * (p2 - 1) + n2);
        long maxQ = (p2 == 1 && n2 == 1) ? 1_000_000 : (k2 - 1) / (m * (p2 - 1) + n2 - 1);
        if (minQ > maxQ) return p1 + " " + n1;

        p1 = (k1 + m * minQ - 1) / (m * minQ);
        if (p1 != (k1 + m * maxQ - 1) / (m * maxQ)) {
            p1 = 0;
        }

        n1 = (k1 + minQ - 1) / minQ % m;

        for (long i = minQ + 1; i <= maxQ; i++) {
            long nN = (k1 + i - 1) / i % m;
            if (nN != n1) {
                return p1 + " " + 0;
            }
        }
        if (n1 == 0) {
            n1 = m;
        }

        return p1 + " " + n1;
    }
}
