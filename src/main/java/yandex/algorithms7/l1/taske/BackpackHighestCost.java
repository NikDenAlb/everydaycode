import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BackpackHighestCost {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxM = Integer.parseInt(reader.readLine().split(" ")[1]);
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] bp = new int[maxM + 1];

        for (int i = 0; i < m.length; i++) {
            for (int j = bp.length - 1 - m[i]; j > 0; j--) {
                if (bp[j] > 0) {
                    bp[j + m[i]] = Math.max(bp[j + m[i]], bp[j] + c[i]);
                }
            }
            if (m[i] < bp.length) {
                bp[m[i]] = Math.max(bp[m[i]], c[i]);
            }
        }

        writer.write(String.valueOf(Arrays.stream(bp).max().orElseThrow()));

        reader.close();
        writer.close();
    }
}
