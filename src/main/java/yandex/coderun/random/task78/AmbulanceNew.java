package yandex.coderun.random.task78;
//TODO not finished
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/ambulance">task link</a><br>
 * test - TODO 1st prior
 */
public class AmbulanceNew {
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

n           1       |          2        |          3        ||          1       |          2        |           3

k   1   2   3   4       5   6   7   8       9   10  11  12      13  14  15  16      17  18  19  20      21  22  23  24
    -   -   -   -   |   -   -   -   -   |   -   -   -   -   ||  -   -   -   -   |   -   -   -   -   |   -   -   -   -   ||

    m*q*(p-1)<k<=m*q*p
    >>> q<k/(m(p-1))
    >>> q>=k/(mp)

    m*q*(p-1)+q*(n-1)<k<=m*q*(p-1)+q*n
    >>> q<k/(m(p-1)+n-1)
    >>> q>=k/(m(p-1)+n)
*/
        long minQ = (k2 + m * (p2 - 1) + n2 - 1) / (m * (p2 - 1) + n2);
        long maxQ;
        if (p2 == 1 && n2 == 1) {
            maxQ = 1_000_000;
        } else maxQ = (k2 - 1) / (m * (p2 - 1) + n2 - 1);

        //k > mq(p-1)
        //p < k/mq + 1

        p1 = k1 / (m * minQ) + 1;
        //p1 = ((k1 + m * minQ - 1) / (m * minQ));

        for (long i = minQ + 1; i <= maxQ; i++) {
            long pNext = (k1 + m * i - 1) / (m * i) + 1;
            if (pNext != p1) {
                p1 = 0;
                break;
            }
        }

        n1 = (k1 + minQ - 1) / minQ % m;

        for (long i = minQ + 1; i <= maxQ; i++) {
            long nNext = (k1 + i - 1) / i % m;
            if (nNext != n1) {
                return p1 + " " + n1;
            }
        }
        if (n1 == 0) {
            n1 = m;
        }

        return p1 + " " + n1;
    }
}
