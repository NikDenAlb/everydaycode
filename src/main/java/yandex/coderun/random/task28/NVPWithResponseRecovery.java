package yandex.coderun.random.task28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/nvp-with-response-recovery">task link</a><br>
 * test - OK
 */
public class NVPWithResponseRecovery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();//N
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[nums.length];
        int[] pInd = new int[nums.length];

        int mLen = 1;
        int bInd = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pInd[i] = j;
                }
            }
            if (dp[i] > mLen) {
                mLen = dp[i];
                bInd = i;
            }
        }

        int[] out = new int[mLen + 1];
        for (int i = 0; i < out.length; i++) {
            out[out.length - 1 - i] = nums[bInd];
            bInd = pInd[bInd];
        }

        writer.write(Arrays.stream(out).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
