package yandex.coderun.random.task134;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/good-line">task link</a><br>
 * test - OK
 */
public class GoodLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.min(arr[i], arr[i + 1]);
        }

        writer.write(Long.toString(sum));

        reader.close();
        writer.close();
    }
}
