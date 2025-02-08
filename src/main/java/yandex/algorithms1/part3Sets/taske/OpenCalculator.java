package yandex.algorithms1.part3Sets.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

/**
 * test - OK
 */
public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().split(" ");
        int x = Integer.parseInt(nums[0]);
        int y = Integer.parseInt(nums[1]);
        int z = Integer.parseInt(nums[2]);
        int n = Integer.parseInt(reader.readLine());

        HashSet<Integer> set = new HashSet<>(Arrays.asList(x, y, z));
        do {
            set.add(n % 10);
            n = n / 10;
        } while (n > 0);
        writer.write(String.valueOf(set.size() - 3));

        reader.close();
        writer.close();
    }
}
