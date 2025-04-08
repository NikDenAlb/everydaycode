package yandex.coderun.random.task136;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/sntp">task link</a><br>
 * test - OK
 */
public class SNTP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int sA = a[0] * 3600 + a[1] * 60 + a[2];
        int sB = b[0] * 3600 + b[1] * 60 + b[2];
        int sC = c[0] * 3600 + c[1] * 60 + c[2];

        int s24 = 24 * 3600;

        int sD = (sC < sA) ? s24 - sA + sC : sC - sA;
        int sDH = (sD + 1) / 2;

        int sOut = sB + sDH;

        writer.write(String.format("%02d:%02d:%02d", sOut / 3600 % 24, sOut / 60 % 60, sOut % 60));

        reader.close();
        writer.close();
    }
}
