import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class KthZero {
    //input arr
    static int[] arr;

    //size of bottom part of the tree array (with neutral elements initialization
    static int sizeBot;

    //degree of sizeBot (sizeBot==2<<shift), for 2^k k==shift+1
    static int shift;

    //segmentTree
    static int[] sT;

    //for fast degree calculation
    static int[] shiftArr;

    //mask for removing upper bits
    static int mask;

    static int goal;
    static int ans;

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
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void executeCommand(String[] command) {
        switch (command[0]) {
            case "s" -> computeIndexOfKthZero(
                    Integer.parseInt(command[1]) - 1,
                    Integer.parseInt(command[2]) - 1,
                    Integer.parseInt(command[3]));
            case "u" -> update(Integer.parseInt(command[1]) - 1, Integer.parseInt(command[2]));
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
    static void update(int index, int newValue) {
        sT[index] = newValue == 0 ? 1 : 0;
        int lvlUp = 2 << shift;
        for (int i = 0; i < shift + 1; i++) {
            index = (index >> 1) + lvlUp;
            sT[index] = sT[(index << 1) & mask] + sT[((index << 1) & mask) + 1];
        }
    }

    static void buildSegmentTree() {
        sizeBot = 1;
        shift = -1;
        while (arr.length > sizeBot) {
            shift++;
            sizeBot <<= 1;
        }
        sT = new int[2 * sizeBot - 1];
        mask = sT.length;
        shiftArr = new int[2 * sizeBot - 1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sT[i] = 1;
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
                sT[i] = sT[(i << 1) & mask] + sT[((i << 1) & mask) + 1];
                shiftArr[i] = j - 1;
            }
            j--;
        }
        if (sizeBot > 1) {
            sT[i] = sT[i - 2] + sT[i - 1];
            shiftArr[i] = j;
        }
    }

    static void computeIndexOfKthZero(int a, int b, int k) {
        goal = k;
        ans = -2;
        calcNode(a, b, sT.length - 1);
        out.append(ans + 1).append(" ");
    }

    /*
        []  []  []  []  []  []  []  []  []  []  []  []  []  []  []  []
          []      []      []      []      []      []      []      []
              []              []              []              []
                      []                              []
                                      []
     */
    static void calcNode(int a, int b, int index) {
        if (goal == -1) {
            return;
        }

        int left = index < sizeBot ? index : (index << ((shift + 1) - shiftArr[index])) & mask;
        int right = index < sizeBot ? index : left + (mask >> (shiftArr[index] + 1));
        //full
        if (left >= a &&
                right <= b
        ) {
            if (goal > sT[index]) {
                goal -= sT[index];
                return;
            }
            if (goal == sT[index]) {
                if (index < sizeBot) {
                    ans = index;
                    goal = -1;
                    return;
                }
            }
            calcNode(a, b, (index << 1) & mask);
            calcNode(a, b, ((index << 1) & mask) + 1);
            return;
        }
        //!full
        if (left > b ||
                right < a
        ) {
            return;
        }
        //partially
        calcNode(a, b, (index << 1) & mask);
        calcNode(a, b, ((index << 1) & mask) + 1);
    }
}