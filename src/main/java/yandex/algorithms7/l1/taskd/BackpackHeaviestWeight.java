import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BackpackHeaviestWeight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(reader.readLine().split(" ")[1]);
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[] bp = new boolean[m + 1];
        bp[0] = true;
        for (int k : n) {
            for (int j = bp.length - 1 - k; j >= 0; j--) {
                if (bp[j]) {
                    bp[j + k] = true;
                }
            }
        }

        for (int i = bp.length - 1; ; i--) {
            if (bp[i]) {
                writer.write(String.valueOf(i));

                reader.close();
                writer.close();
                return;
            }
        }
    }
}
