import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MaximumOnSubsegmentsWithAdditionOnSegment {
    //input arr
    static int[] arr;

    //size of bottom part of the tree array (with neutral elements initialization
    static int sizeBot;

    //degree of sizeBot (sizeBot==2<<shift), for 2^k k==shift+1
    static int shift;

    //segmentTree [0] - baseValue [1] - add
    static long[][] sT;

    //for fast degree calculation
    static int[] shiftArr;

    //mask for removing upper bits
    static int mask;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 8388608);
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
            case "m" -> get(Integer.parseInt(command[1]) - 1, Integer.parseInt(command[2]) - 1);
            case "a" -> update(Integer.parseInt(command[1]) - 1,
                    Integer.parseInt(command[2]) - 1,
                    Integer.parseInt(command[3]));
            default -> throw new RuntimeException();
        }
    }

    static void keepPromise(int index) {
        if (sT[index][1] != 0) {
            sT[index][0] += sT[index][1];
            if (index >= sizeBot) {
                sT[(index << 1) & mask][1] += sT[index][1];
                sT[((index << 1) & mask) + 1][1] += sT[index][1];
            }
            sT[index][1] = 0;
        }
    }

    static void update(int a, int b, long add) {
        updateNode(a, b, add, sT.length - 1);
    }
    /*
        [ 0]    [ 1]    [ 2]    [ 3]    [ 4]    [ 5]    [ 6]    [ 7]    [ 8]    [ 9]    [10]    [11]    [12]    [13]    [14]    [15]
            [16]            [17]            [18]            [19]            [20]            [21]            [22]            [23]
                    [24]                            [25]                            [26]                            [27]
                                    [28]                                                            [29]
                                                                    [30]
    */
    static long updateNode(int a, int b, long add, int index) {
        keepPromise(index);
        int left = (index << (shift + 1 - shiftArr[index])) & mask;
        int right = left + (mask >> (shiftArr[index] + 1));

        //full
        if (left >= a && right <= b) {
            if (index >= sizeBot) {
                sT[(index << 1) & mask][1] += add;
                sT[((index << 1) & mask) + 1][1] += add;
            }
            sT[index][0] += add;
            return sT[index][0];
        }
        //!full
        if (left > b || right < a) {
            return sT[index][0];
        }
        //partially
        long l = updateNode(a, b, add, (index << 1) & mask);
        long r = updateNode(a, b, add, ((index << 1) & mask) + 1);
        sT[index][0] = Math.max(l, r);
        return sT[index][0];
    }

    static void buildSegmentTree() {
        sizeBot = 1;
        shift = -1;
        while (arr.length > sizeBot) {
            shift++;
            sizeBot <<= 1;
        }
        sT = new long[2 * sizeBot - 1][2];
        mask = sT.length;
        shiftArr = new int[2 * sizeBot - 1];

        for (int i = 0; i < arr.length; i++) {
            sT[i][0] = arr[i];
            shiftArr[i] = shift + 1;
        }
        for (int i = arr.length; i < sizeBot; i++) {
            sT[i][0] = Long.MIN_VALUE;
            shiftArr[i] = shift + 1;
        }

        int i = sizeBot - 1, j = shift + 1;
        while (j > 0) {
            for (int k = 0; k < 1 << (j - 1); k++) {
                i++;
                sT[i][0] = Math.max(sT[(i << 1) & mask][0], sT[((i << 1) & mask) + 1][0]);
                shiftArr[i] = j - 1;
            }
            j--;
        }
        if (sizeBot > 1) {
            sT[i][0] = Math.max(sT[i - 2][0], sT[i - 1][0]);
            shiftArr[i] = j;
        }
        shiftArr[i] = j;
    }

    static void get(int a, int b) {
        out.append(getNode(a, b, sT.length - 1)).append(' ');
    }

    static long getNode(int a, int b, int index) {
        keepPromise(index);
        int left = (index << (shift + 1 - shiftArr[index])) & mask;
        int right = left + (mask >> (shiftArr[index] + 1));

        //full
        if (left >= a && right <= b) {
            return sT[index][0];
        }
        //!full
        if (left > b || right < a) {
            return Long.MIN_VALUE;
        }
        //partially
        long l = getNode(a, b, (index << 1) & mask);
        long r = getNode(a, b, ((index << 1) & mask) + 1);
        return Math.max(l, r);
    }
}
