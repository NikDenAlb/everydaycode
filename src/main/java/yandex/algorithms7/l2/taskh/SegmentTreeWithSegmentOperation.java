import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SegmentTreeWithSegmentOperation {
    //input arr
    static int[] arr;

    //size of bottom part of the tree array (with neutral elements initialization
    static int sizeBot;

    //degree of sizeBot (sizeBot==2<<shift), for 2^k k==shift+1
    static int shift;

    //segmentTree
    static long[] sT;

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
            case "g" -> get(Integer.parseInt(command[1]) - 1);
            case "a" -> update(Integer.parseInt(command[1]) - 1,
                    Integer.parseInt(command[2]) - 1,
                    Integer.parseInt(command[3]));
            default -> throw new RuntimeException();
        }
    }


    static void update(int a, int b, long add) {
        updateNode(a, b, add, sT.length - 1);
    }

    static void updateNode(int a, int b, long add, int index) {
        int left = (index << (shift + 1 - shiftArr[index])) & mask;
        int right = left + (mask >> (shiftArr[index] + 1));

        //full
        if (left >= a && right <= b) {
            sT[index] += add;
            return;
        }
        //!full
        if (left > b || right < a) {
            return;
        }
        //partially
        updateNode(a, b, add, (index << 1) & mask);
        updateNode(a, b, add, ((index << 1) & mask) + 1);
    }

    static void buildSegmentTree() {
        sizeBot = 1;
        shift = -1;
        while (arr.length > sizeBot) {
            shift++;
            sizeBot <<= 1;
        }
        sT = new long[2 * sizeBot - 1];
        mask = sT.length;
        shiftArr = new int[2 * sizeBot - 1];

        for (int i = 0; i < arr.length; i++) {
            sT[i] = arr[i];
            shiftArr[i] = shift + 1;
        }
        for (int i = arr.length; i < sizeBot; i++) {
            shiftArr[i] = shift + 1;
        }

        int i = sizeBot - 1, j = shift + 1;
        while (j > 0) {
            for (int k = 0; k < 1 << (j - 1); k++) {
                i++;
                shiftArr[i] = j - 1;
            }
            j--;
        }
        if (sizeBot > 1) {
            shiftArr[i] = j;
        }
        shiftArr[i] = j;
    }

    static void get(int index) {
        keepPromise(index, sT.length - 1);
        out.append(sT[index]).append('\n');
    }

    static void keepPromise(int target, int index) {
        int lC = (index << 1) & mask;
        int rC = ((index << 1) & mask) + 1;

        sT[lC] += sT[index];
        sT[rC] += sT[index];
        sT[index] = 0;
        if (shiftArr[index] == shift) {
            return;
        }
        int left = (index << (shift + 1 - shiftArr[index])) & mask;
        int right = left + (mask >> (shiftArr[index] + 1));
        int mid = (left + right) / 2;

        if (target <= mid) {
            keepPromise(target, lC);
            return;
        }
        keepPromise(target, rC);
    }
}
