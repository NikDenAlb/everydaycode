package yandex.algorithms7.l1.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ComputerForEveryone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // N and M
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int[] ans = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            int t = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < m.length; j++) {
                if (m[j] > n[i]) {
                    if (m[j] < t) {
                        t = m[j];
                        index = j;
                    }
                }
            }
            if (index > -1) {
                count++;
                m[index] = 0;
            }
            ans[i] = index + 1;
        }

        writer.write(count + "\n" +
                Arrays.stream(ans)
                        .boxed()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
