import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Zeroes {
    //input arr
    static int[] arr;

    //size of bottom part of the tree array (with neutral elements initialization
    static int sizeBot;

    //degree of sizeBot (sizeBot==2<<shift), for 2^k k==shift+1
    static int shift;

    //segmentTree [0]-left [1]-right, [2]-total
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
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            executeCommand(reader.readLine().split(" "));
        }
        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void executeCommand(String[] command) {
        switch (command[0]) {
            case "QUERY" -> query(Integer.parseInt(command[1]) - 1, Integer.parseInt(command[2]) - 1);
            case "UPDATE" -> update(Integer.parseInt(command[1]) - 1, Integer.parseInt(command[2]));
            default -> throw new RuntimeException();
        }
    }

    /*
            [   0]      [   1]      [   2]      [   3]      [   4]      [   5]      [   6]      [   7]
                  [   8]                  [   9]                  [  10]                  [  11]
                              [  12]                                          [  13]
                                                      [  14]


            [0000]      [0001]      [0010]      [0011]      [0100]      [0101]      [0110]      [0111]
                  [1000]                  [1001]                  [1010]                  [1011]
                              [1100]                                          [1101]
                                                      [1110]
    */
    static void update(int i, int x) {
        sT[i] = x == 0 ? new int[]{1, 1, 1, 1} : new int[]{0, 0, 0, 0};
        int lvlUp = 2 << shift;
        for (int j = 0; j < shift + 1; j++) {
            i = (i >> 1) + lvlUp;
            int[] l = sT[(i << 1) & mask];
            int[] r = sT[((i << 1) & mask) + 1];
            sT[i][0] = l[3] == 1 ? l[0] + r[0] : l[0];
            sT[i][1] = r[3] == 1 ? r[1] + l[1] : r[1];
            sT[i][2] = Math.max(Math.max(
                            l[2],
                            r[2]),
                    l[1] + r[0]);
            sT[i][3] = Math.min(l[3], r[3]);
        }
    }

    static void buildSegmentTree() {
        sizeBot = 1;
        shift = -1;
        while (arr.length > sizeBot) {
            shift++;
            sizeBot <<= 1;
        }
        sT = new int[2 * sizeBot - 1][4];
        mask = sT.length;
        shiftArr = new int[2 * sizeBot - 1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sT[i] = new int[]{1, 1, 1, 1};
            }
            shiftArr[i] = shift + 1;
        }
        for (int i = arr.length; i < sizeBot; i++) {
            shiftArr[i] = shift + 1;
        }

        int i = sizeBot - 1, j = shift + 1;
        while (j > 0) {
            for (int k = 0; k < 1 << (j - 1); k++) {
                i++;
                int[] l = sT[(i << 1) & mask];
                int[] r = sT[((i << 1) & mask) + 1];

                sT[i][0] = l[3] == 1 ? l[0] + r[0] : l[0];
                sT[i][1] = r[3] == 1 ? r[1] + l[1] : r[1];
                sT[i][2] = Math.max(Math.max(
                                l[2],
                                r[2]),
                        l[1] + r[0]);
                sT[i][3] = Math.min(l[3], r[3]);

                shiftArr[i] = j - 1;
            }
            j--;
        }
        if (sizeBot > 1) {
            shiftArr[i] = j;
            int[] l = sT[i - 2];
            int[] r = sT[i - 1];
            sT[i][0] = l[3] == 1 ? l[0] + r[0] : l[0];
            sT[i][1] = r[3] == 1 ? r[1] + l[1] : r[1];
            sT[i][2] = Math.max(Math.max(
                            l[2],
                            r[2]),
                    l[1] + r[0]);
            sT[i][3] = Math.min(l[3], r[3]);
        }
        shiftArr[i] = j;
    }

    static void query(int l, int r) {
        out.append(calcNode(l, r, sT.length - 1)[2]).append("\n");
    }

    /*
    [ 0]    [ 1]    [ 2]    [ 3]    [ 4]    [ 5]    [ 6]    [ 7]    [ 8]    [ 9]    [10]    [11]    [12]    [13]    [14]    [15]
        [16]            [17]            [18]            [19]            [20]            [21]            [22]            [23]
                [24]                            [25]                            [26]                            [27]
                                [28]                                                            [29]
                                                                [30]
     */
    static int[] calcNode(int a, int b, int index) {
        int left = index < sizeBot ? index : (index << (shift + 1 - shiftArr[index])) & mask;
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
            return new int[]{0, 0, 0, 0};
        }
        //partially
        int[] l = calcNode(a, b, (index << 1) & mask);
        int[] r = calcNode(a, b, ((index << 1) & mask) + 1);

        int[] out = new int[4];
        out[0] = l[3] == 1 ? l[0] + r[0] : l[0];
        out[1] = r[3] == 1 ? r[1] + l[1] : r[1];
        out[2] = Math.max(Math.max(
                        l[2],
                        r[2]),
                l[1] + r[0]);
        out[3] = Math.min(l[3], r[3]);
        return out;
    }
}
