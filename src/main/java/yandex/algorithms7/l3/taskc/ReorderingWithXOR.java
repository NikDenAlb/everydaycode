import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReorderingWithXOR {
    //original nums in sorted order
    static long[] sortedNums;

    //original nums in sorted order but in ones count
    static int[] sortedOnes;

    //max digits
    static int digits;

    static long xor;

    static int n;

    /*
               original                       sorted                     final
            0  [101011]                      [100000]                   [000001]

            1  [001000]                      [110000]                   [110000]
            2  [010101]                      [111000]                   [110100]

            3  [111111]                      [111000]                   [111000]
            4  [100001]                      [111100]                   [111100]

            5  [001110]                      [111110]                   [111110] -look XOR. if 0 and 1 on same lvl - swap
            6  [110111]                      [111111]                   [111111] -always same
               |digits|              XOR:     101101             XOR:    000000


              0   1   2   3   4   5   6
            [43][.8][21][63][33][14][55] - nums

            [.4][.1][.3][.6][.2][.3][.5] - ones in nums
                       /|\
            [.1][.4][.2][.5][.0][.6][.3] - indexes of ones in sorted arr
            [.1][.2][.3][.3][.4][.5][.6] - sortedOnes


              0   1   2   3   4   5   6
            [.1][.2][.3][.3][.4][.5][.6] - sortedOnes
            [.-][.+][.-][.-][.+][.-][.-] - blocked
    */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        long[] nums = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long mNum = 0;
        digits = 63;
        int[] ones = new int[n];
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            int count = 0;
            mNum = Math.max(mNum, num);
            while (num > 0) {
                num &= (num - 1);
                count++;
            }
            ones[i] = count;
        }

        //digits works fine
        while (1L << (digits - 1) > mNum) {
            digits--;
        }

        Integer[] indexesInt = new Integer[ones.length];
        for (int i = 0; i < ones.length; i++) {
            indexesInt[i] = i;
        }

        //indexes for reversing sorted order int the end
        int[] indexes = IntStream.range(0, nums.length)
                .boxed()
                .sorted(Comparator.comparingLong(i -> ones[i]))
                .mapToInt(i -> i)
                .toArray();

        long mask = ~(Long.MAX_VALUE << digits);
        sortedOnes = Arrays.stream(indexes).map(index -> ones[index]).toArray();
        int flDigits = digits;
        sortedNums = Arrays.stream(sortedOnes).mapToLong(i -> mask << (flDigits - i) & mask).toArray();
        xor = xorArr(sortedNums);

        sort();

        if (xor == 0) {
            long[] out = new long[n];
            for (int i = 0; i < indexes.length; i++) {
                out[indexes[i]] = sortedNums[i];
            }
            writer.write(Arrays.stream(out).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

            reader.close();
            writer.close();
            return;
        }

        while (countOnes(xor) % 2 == 0 && xor > 0) {
            reBalanceTwo();
            sort();
        }

        if (xor > 0) {
            writer.write("impossible");

            reader.close();
            writer.close();
            return;
        }

        long[] out = new long[n];
        for (int i = 0; i < indexes.length; i++) {
            out[indexes[i]] = sortedNums[i];
        }
        writer.write(Arrays.stream(out).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }

    static long xorArr(long[] arr) {
        long out = arr[0];
        for (int i = 1; i < arr.length; i++) {
            out ^= arr[i];
        }
        return out;
    }

    static int countOnes(long num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    static void sort() {
        for (int i = n - 1; i > 0; i--) {
            int zeroOne = -1, oneOne = -1;
            for (int j = sortedOnes[i] + 1; j <= digits; j++) {
                if (((1L << (digits - j)) & xor) > 0) {
                    zeroOne = j;
                    break;
                }
            }
            if (zeroOne > -1) {
                for (int j = 1; j <= sortedOnes[i]; j++) {
                    if (((1L << (digits - j)) & xor) > 0) {
                        oneOne = j;
                        break;
                    }
                }
            }
            if (oneOne > -1) {
                sortedNums[i] |= (1L << (digits - zeroOne));
                sortedNums[i] &= ~(1L << (digits - oneOne));
                xor &= ~(1L << (digits - zeroOne));
                xor &= ~(1L << (digits - oneOne));
            }
        }
    }

    static void reBalanceTwo() {
        for (int i = 0; i < n; i++) {
            for (int j = digits - 1; j > 0; j--) {
                if ((sortedNums[i] & (1L << j)) == (xor & (1L << j)) && (xor & (1L << j)) > 0) {
                    for (int k = 0; k < j; k++) {
                        if ((xor & (1L << k)) == 0 || (sortedNums[i] & (1L << k)) == (xor & (1L << k))) {
                            sortedNums[i] &= ~(1L << j);
                            sortedNums[i] |= (1L << k);
                            xor &= ~(1L << j);
                            xor |= (1L << k);
                            return;
                        }
                    }
                }
            }
        }
    }
}
