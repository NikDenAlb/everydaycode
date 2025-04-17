package yandex.coderun.random.task131;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/beautiful-line">task link</a><br>
 * test - OK
 */
public class BeautifulLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine());

        String str = reader.readLine();

        Map<Character, Integer> map = new HashMap<>();

        int max = 0, l = 0, r = 0;

        while (r < str.length()) {

            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);

            max = Math.max(max, map.get(str.charAt(r)));

            for (int replaces = r - l + 1 - Math.max(max, map.get(str.charAt(r))); replaces > k; ) {
                map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                l++;
                replaces--;
            }

            r++;
        }

        writer.write(String.valueOf(r - l));

        reader.close();
        writer.close();
    }
}
