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
public class AmbulanceBrute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int k1 = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k2 = Integer.parseInt(input[2]);
        int p2 = Integer.parseInt(input[3]);
        int n2 = Integer.parseInt(input[4]);

        writer.write(findAddressBrute(k1, m, k2, p2, n2));

        reader.close();
        writer.close();
    }

    static String findAddressBrute(int k1, int m, int k2, int p2, int n2) {
        int p1 = -1;
        int n1 = -1;

        if (m < n2) {
            return p1 + " " + n1;
        }

        int maxQ = 1_000_000;
        int firstQ = 0;

        for (int i = 1; i <= maxQ; i++) {
            if (k2 > (long) m * i * (p2 - 1) + (long) (n2 - 1) * i
                    && k2 <= (long) m * i * (p2 - 1) + (long) n2 * i) {
                firstQ = i;
                break;
            }
        }
        if (firstQ == 0) {
            return p1 + " " + n1;
        }
        int lastQ = 0;

        for (int i = firstQ + 1; i <= maxQ; i++) {
            if (k2 > (long) m * i * (p2 - 1) + (long) (n2 - 1) * i
                    && k2 <= (long) m * i * (p2 - 1) + (long) n2 * i) {
                lastQ = i;
            } else
                break;
        }

        p1 = (int) ((k1 + (long) m * firstQ - 1) / ((long) m * firstQ));

        for (int i = firstQ + 1; i <= lastQ; i++) {
            int pNew = (int) ((k1 + (long) m * i - 1) / ((long) m * i));
            if (p1 != pNew) {
                p1 = 0;
                break;
            }
        }

        n1 = ((k1 + firstQ - 1) / firstQ) % m;
        if (n1 == 0) {
            n1 = m;
        }

        for (int i = firstQ + 1; i <= lastQ; i++) {
            int nNew = ((k1 + i - 1) / i) % m;
            if (nNew == 0) {
                nNew = m;
            }
            if (n1 != nNew) {
                n1 = 0;
                break;
            }
        }
        return p1 + " " + n1;
    }
}
