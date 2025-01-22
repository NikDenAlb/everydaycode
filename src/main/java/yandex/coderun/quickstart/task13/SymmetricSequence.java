package yandex.coderun.quickstart.task13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/symmetric-sequence">task link</a><br>
 * test - OK
 */
public class SymmetricSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] sNums = reader.readLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sNums[i]);
        }

        int[] result = makeSymmetricSequence(nums);
        if (result.length == 0) {
            writer.write('0');
        } else {
            StringBuilder out = new StringBuilder();
            out.append(result.length).append('\n');
            for (int i = 0; i < result.length - 1; i++) {
                out.append(result[i]).append(' ');
            }
            out.append(result[result.length - 1]);
            writer.write(out.toString());
        }

        reader.close();
        writer.close();
    }

    static int[] makeSymmetricSequence(int[] nums) {
        int outLen = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            boolean isSymmetric = true;
            for (int j = i; nums.length - 1 + i - j > j; j++) {
                if (nums[nums.length - 1 + i - j] != nums[j]) {
                    isSymmetric = false;
                    break;
                }
            }
            if (isSymmetric) {
                outLen = i;
                break;
            }
        }
        int[] out = new int[outLen];
        for (int i = 0; i < outLen; i++) {
            out[i] = nums[outLen - 1 - i];
        }
        return out;
    }
}
