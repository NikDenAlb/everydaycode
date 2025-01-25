package yandex.coderun.quickstart.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/triangle">task link</a><br>
 * test - OK
 */
public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        if (    nums[0] < nums[1] + nums[2] &&
                nums[1] < nums[0] + nums[2] &&
                nums[2] < nums[0] + nums[1]) {
            writer.write("YES");
        } else
            writer.write("NO");

        reader.close();
        writer.close();
    }
}
