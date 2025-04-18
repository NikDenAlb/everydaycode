package livecoding.coderun.task78;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/ambulance">task link</a><br>
 * <a href="https://youtu.be/WAkGXEbPDxo">video link</a>
 */
public class Ambulance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(findLostInfo(inp[0], inp[1], inp[2], inp[3], inp[4]));

        reader.close();
        writer.close();
    }

/*
    p                                   1                       ||                              2                           ||
    n           1       |           2       |           3       ||           1       |           2       |           3      ||
    k   1   2   3   4   |   5   6   7   8   |   9   10  11  12  ||   13  14  15  16  |   17  18  19  20  |   21  22  23  24 ||
        -   -   -   -   |   -   -   -   -   |   -   -   -   -   ||   -   -   -   -   |   -   -   -   -   |   -   -   -   -  ||   -   -   -
    %m          1                   2                   0                    1                   2                   0
    m=3
    q=4?

    k> ((p-1)m+(n-1))q          k> (p-1)mq
    k<=((p-1)m+n)q              k<=pmq

    |------- ------- ------- ------
    |divider|       |       |       |
*/
    static String findLostInfo(int k1, int m, int k2, int p2, int n2) {
        int p1 = -1, n1 = -1;

        if (n2 > m || (long) k2 <= ((long) p2 - 1) * m + n2 - 1) {
            return p1 + " " + n1;
        }

        int minQ = (int) ((long) k2 + (p2 - 1) * m + n2 - 1) / ((p2 - 1) * m + n2);
        int maxQ = (p2 == 1 && n2 == 1) ? 1_000_000 : (int) ((long) k2 - 1) / ((p2 - 1) * m + n2 - 1);
        if (minQ > maxQ) {
            return p1 + " " + n1;
        }

        p1 = (int) ((long) k1 + m * minQ - 1) / (m * minQ);

        if (p1 != (int) ((long) k1 + m * maxQ - 1) / (m * maxQ)) {
            p1 = 0;
        }

        n1 = (k1 + minQ - 1) / minQ % m;
        for (int i = minQ + 1; i <= maxQ; i++) {
            int newN1 = (k1 + i - 1) / i % m;
            if (n1 != newN1) {
                return p1 + " " + 0;
            }
        }
        if (n1 == 0) {
            n1 = m;
        }

        return p1 + " " + n1;
    }
}
