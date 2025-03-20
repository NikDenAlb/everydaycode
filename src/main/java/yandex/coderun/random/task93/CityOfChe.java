package yandex.coderun.random.task93;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/city-of-che">task link</a><br>
 * test - OK
 */
public class CityOfChe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        int r = Integer.parseInt(input[1]);
        int[] d = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long count = 0;

        for (int iL = 0, iR = 1; d[d.length - 1] - d[iL] > r; ) {
            if (d[iR] - d[iL] > r) {
                count += d.length - iR;
                iL++;
            } else {
                iR++;
            }
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}
