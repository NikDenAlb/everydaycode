package yandex.coderun.random.task17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/conveyor">task link</a><br>
 * test - TODO
 */
public class Conveyor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(isOrder(reader.readLine())).append('\n');
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    /*
             |
         |   |
         |   |  |
     |   |   |  |
     */
    static String isOrder(String s) {
        double[] arr = Arrays.stream(s.split(" ")).skip(1).mapToDouble(Double::parseDouble).toArray();
        double min = arr[0], minActive = Double.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                if (arr[i] < minActive) {
                    return "0";
                }
                min = arr[i];
            } else if (arr[i] > min) {
                minActive = min;
            }
        }
        return "1";
    }
}


/*
4
5 80 39 30 73 62
16 5 4 3 2 3 5 6 7 8 7 6 5 4 3 2 1
2 2.9 2.1
3 5.6 9.0 2.0
 */
