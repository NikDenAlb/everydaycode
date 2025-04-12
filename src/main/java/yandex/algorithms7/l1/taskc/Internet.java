import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Internet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] pP = new int[31];
        pP[0] = a[0];
        for (int i = 1; i < pP.length; i++) {
            pP[i] = Math.max(pP[i - 1] << 1, a[i]);
        }

        int index = 0;
        while (pP[index] << 1 < m && index < pP.length - 1) {
            index++;
        }

        int out = 0;
        do {
            if (index == 0) {
                out += (((m + pP[index] - 1) / pP[index]) << index);
                break;
            }
            out += (m / pP[index]) << index;
            m = m % pP[index];
            if (m >= pP[index - 1] << 1) {
                out += 1 << index;
                break;
            }
            index--;
        }
        while (m > 0);

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}
