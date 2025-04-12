package yandex.algorithms7.l1.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoMoreNoLess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine(); // n
            int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> ans = splitArr(a);
            out.append(ans.size()).append("\n");
            ans.forEach(e -> out.append(e).append(" "));
            out.setCharAt(out.length() - 1, '\n');
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static List<Integer> splitArr(int[] arr) {
        List<Integer> out = new ArrayList<>();
        int currLen = 1;
        int maxLen = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < currLen + 1 || maxLen == currLen) {
                out.add(currLen);
                currLen = 1;
                maxLen = arr[i];
                continue;
            }
            currLen++;
            maxLen = Math.min(maxLen, arr[i]);
        }

        if (arr[arr.length - 1] < currLen + 1 || maxLen == currLen) {
            out.add(currLen);
            if (arr.length > 1) {
                out.add(1);
            }
            return out;
        }

        out.add(++currLen);

        return out;
    }
}
