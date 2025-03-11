package yandex.coderun.random.task67;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
1 2 3 4 5 -> (1 2 3 4 5) 4 3 2 1

3   5   7   5   3
        |

1   2   3   5   7   5   3|| 2   1
                |
1                               1
    2                       2
        3               3


1   2   3   5   7   5   3||
1                       3
1|  2   3   5   7   5   3|| 1
    2                   3
1   2|  3   5   7   5   3|| 2   1
        3               3
            5       5
                7
*/

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/symmetric-sequence">task link</a><br>
 * test - OK
 */
public class SymmetricSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = addForSymmetric(nums);

        StringBuilder out = new StringBuilder();
        out.append(m).append("\n");

        for (int i = m - 1; i >= 0; i--) {
            out.append(nums[i]).append(" ");
        }

        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int addForSymmetric(int[] nums) {
        int m = 0;
        boolean flag = false;
        do {
            for (int i = m, j = nums.length - 1; i < j; i++, j--) {
                if (nums[i] != nums[j]) {
                    m++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return m;
            }
            flag = false;
        } while (m < nums.length);
        return m;
    }
}
