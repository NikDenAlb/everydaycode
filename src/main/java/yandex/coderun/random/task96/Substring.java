package yandex.coderun.random.task96;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/substring">task link</a><br>
 * test - OK
 */
public class Substring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine().split(" ")[1]);
        String s = reader.readLine();
        StringBuilder out = new StringBuilder();
        int[] ans = findSubstring(s, k);
        out.append(ans[0]).append(" ").append(ans[1]);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int[] findSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int[] ans = new int[]{0, -1};
        for (int l = 0, r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.get(s.charAt(r)) > k) {
                while (map.get(s.charAt(r)) > k) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
            }
            if (r - l + 1 > ans[0]) {
                ans[0] = r - l + 1;
                ans[1] = l + 1;
            }
        }
        return ans;
    }
}
