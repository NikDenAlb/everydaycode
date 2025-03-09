package livecoding.coderun.task65;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
5
    1
111111111111111
    3 last

-1-1-1-1-1-1-1
    3 last

-1-1-1-1-1 1111111111
2first1last | 3last

-1-1-1-1-1-1 0
1last

-1-1011
*/
/**
 * <a href="https://coderun.yandex.ru/problem/largest-product-three-numbers">task link</a><br>
 * <a href="https://youtu.be/iLRvhwiihO8">video link</a>
 */
public class LargestProductThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        if (nums.length <= 5) {
            writer.write(bruteFive(nums));
        } else {
            int[] numsFive;
            int f1 = Integer.MAX_VALUE, f2 = Integer.MAX_VALUE,
                    l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, l3 = Integer.MIN_VALUE;

            for (int num : nums) {
                if (f2 > num) {
                    if (f1 > num) {
                        f2 = f1;
                        f1 = num;
                    } else {
                        f2 = num;
                    }
                }

                if (l1 < num) {
                    if (l2 < num) {
                        if (l3 < num) {
                            l1 = l2;
                            l2 = l3;
                            l3 = num;
                        } else {
                            l1 = l2;
                            l2 = num;
                        }
                    } else {
                        l1 = num;
                    }
                }
            }
            writer.write(bruteFive(new int[]{f1, f2, l1, l2, l3}));
        }

        reader.close();
        writer.close();
    }

    static String bruteFive(int[] nums) {
        int a = 0, b = 0, c = 0;
        long multy = Long.MIN_VALUE;

        for (int i1 = 0; i1 < nums.length - 2; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length - 1; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    if (multy < (long) nums[i1] * nums[i2] * nums[i3]) {
                        a = nums[i1];
                        b = nums[i2];
                        c = nums[i3];
                        multy = (long) nums[i1] * nums[i2] * nums[i3];
                    }
                }
            }
        }
        return a + " " + b + " " + c;
    }
}
