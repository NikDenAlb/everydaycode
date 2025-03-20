package yandex.coderun.random.task93;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CityOfCheBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        int r = Integer.parseInt(input[1]);
        int[] d = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for (int iL = 0; d[d.length - 1] - d[iL] > r; iL++) {
            int left = iL, right = d.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (d[mid] - d[iL] <= r) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            count += d.length - right;
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}
