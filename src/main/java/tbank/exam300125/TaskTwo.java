package tbank.exam300125;
//exam variant. no modifications

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
20 1
21 10
22 110
23 1110
24 11110
bu 10110101010101
 */
public class TaskTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        long[] ams = new long[n];
        for (int i = 0; i < ams.length; i++) {
            ams[i] = Long.parseLong(reader.readLine());
        }
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            calcIToOut(out, ams[i]);
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void calcIToOut(StringBuilder out, long burls) {
        if (burls < 7) {
            out.append(-1).append('\n');
            return;
        }
        int startIndex = -1;
        long burlsC = burls;

        do {
            startIndex++;
            burlsC >>= 1;
        } while (burlsC != 0);
        long count3 = ((1L << startIndex) | 1) - 1;
        if (burls - count3 < 3) {
            startIndex--;
            count3 = ((1L << startIndex) | 1) - 1;
        }

        startIndex = -1;
        burlsC = burls - count3;
        do {
            startIndex++;
            burlsC >>= 1;
        } while (burlsC != 0);
        long count2 = ((1L << startIndex) | 1) - 1;
        if (burls - count3 - count2 < 1) {
            startIndex--;
            count2 = ((1L << startIndex) | 1) - 1;
        }

        startIndex = -1;
        burlsC = burls - count3 - count2;
        do {
            startIndex++;
            burlsC >>= 1;
        } while (burlsC != 0);
        long count1 = ((1L << startIndex) | 1) - 1;
        if (count1 == 0) {
            count1++;
        }
        out.append(count3 + count2 + count1).append("\n");
    }
}
