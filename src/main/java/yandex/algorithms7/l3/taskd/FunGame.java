import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FunGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int digits = 0;
        while ((1 << digits) < n) {
            digits++;
        }
        int mask = ~(1 << digits);

        int max = n;
        for (int i = 0; i < digits; i++) {
            n = ((n << 1) >> digits) + (n << 1) & mask;
            max = Math.max(max, n);
        }

        writer.write(String.valueOf(max));

        reader.close();
        writer.close();
    }
}
