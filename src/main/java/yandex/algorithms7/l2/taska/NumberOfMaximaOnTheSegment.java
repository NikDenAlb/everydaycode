package yandex.algorithms7.l2.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    [ 0]    [ 1]    [ 2]    [ 3]    [ 4]    [ 5]    [ 6]    [ 7]    [ 8]    [ 9]    [10]    [11]    [12]    [13]    [14]    [15]
        [16]            [17]            [18]            [19]            [20]            [21]            [22]            [23]
                [24]                            [25]                            [26]                            [27]
                                [28]                                                            [29]
                                                                [30]
*/
public class NumberOfMaximaOnTheSegment {

    //input arr
    static int[] arr;

    //size of bottom part of the tree array (with neutral elements initialization
    static int sizeBot;

    //degree of sizeBot (sizeBot==2<<shift), for 2^k k==shift+1
    static int shift;

    //segmentTree with [0][1] info ([0] - maximum, [1] - count)
    static int[][] sT;

    //for fast degree calculation
    static int[] shiftArr;

    //mask for removing upper bits
    static int mask;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); //N
        arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        buildSegmentTree();
        int k = Integer.parseInt(reader.readLine());
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            computeNumberOfMaxima(a, b);
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void buildSegmentTree() {
        sizeBot = 1;
        shift = -1;
        while (arr.length > sizeBot) {
            shift++;
            sizeBot <<= 1;
        }
        sT = new int[2 * sizeBot - 1][2];
        mask = sT.length;
        shiftArr = new int[2 * sizeBot - 1];

        for (int i = 0; i < arr.length; i++) {
            sT[i][0] = arr[i];
            sT[i][1] = 1;
            shiftArr[i] = shift + 1;
        }
        for (int i = arr.length; i < sizeBot; i++) {
            sT[i][0] = Integer.MIN_VALUE;
            sT[i][1] = 1;
            shiftArr[i] = shift + 1;
        }

        int i = sizeBot - 1, j = shift + 1;
        while (j > 0) {
            for (int k = 0; k < 1 << (j - 1); k++) {
                i++;
                if (sT[(i << 1) & mask][0] > sT[((i << 1) & mask) + 1][0]) {
                    sT[i] = sT[(i << 1) & mask].clone();
                } else if (sT[(i << 1) & mask][0] < sT[((i << 1) & mask) + 1][0]) {
                    sT[i] = sT[((i << 1) & mask) + 1].clone();
                } else {
                    sT[i] = new int[]{sT[(i << 1) & mask][0], sT[(i << 1) & mask][1] + sT[((i << 1) & mask) + 1][1]};
                }

                shiftArr[i] = j - 1;
            }
            j--;
        }
        if (sT[i - 1][0] == sT[i - 2][0]) {
            sT[i][0] = sT[i - 1][0];
            sT[i][1] = sT[i - 1][1] + sT[i - 2][1];
        } else if (sT[i - 1][0] > sT[i - 2][0]) {
            sT[i] = sT[i - 1].clone();
        } else {
            sT[i] = sT[i - 2].clone();
        }
        shiftArr[i] = j;


    }

    static void computeNumberOfMaxima(int a, int b) {
        int[] ans = calcNode(a, b, sT.length - 1);
        out.append(ans[0]).append(" ").append(ans[1]).append("\n");
    }

    static int[] calcNode(int a, int b, int index) {

        int left = index < sizeBot ? index : (index << ((shift + 1) - shiftArr[index])) & mask;
        int right = index < sizeBot ? index : left + (mask >> (shiftArr[index] + 1));
        //full
        if (left >= a &&
                right <= b
        ) {
            return sT[index].clone();
        }
        //!full
        if (left > b ||
                right < a
        ) {
            return new int[]{Integer.MIN_VALUE, 1};
        }
        //partially
        int[] l = calcNode(a, b, (index << 1) & mask);
        int[] r = calcNode(a, b, ((index << 1) & mask) + 1);
        if (l[0] > r[0]) {
            return l;
        } else if (r[0] > l[0]) {
            return r;
        } else {
            return new int[]{l[0], l[1] + r[1]};
        }
    }
}
/*

        [   0]      [   1]      [   2]      [   3]      [    4]      [   5]      [   6]      [   7]
              [   8]                  [   9]                   [  10]                  [  11]
                          [  12]                                           [  13]
                                                  [  14]


        [0000]      [0001]      [0010]      [0011]      [0100]      [0101]      [0110]      [0111]
              [1000]                  [1001]                  [1010]                  [1011]
                          [1100]                                          [1101]
                                                  [1110]

                              mask=1111
*/
