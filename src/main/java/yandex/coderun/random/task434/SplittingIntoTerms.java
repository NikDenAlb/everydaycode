package yandex.coderun.random.task434;
//TODO
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SplittingIntoTerms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();

        printAllUniqueParts(n, out);

        String[] lines = out.toString().split("\n");
        out = new StringBuilder();
        for (int i = lines.length - 1; i > 0; i--) {
            out.append(lines[i]).append("\n");
        }
        out.append(lines[0]);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void printArray(int[] p, int n, StringBuilder out) {
        for (int i = 0; i < n; i++) {
            out.append(p[i]).append(" + ");
        }
        out.setLength(out.length() - 3);
        out.append("\n");
    }

    static void printAllUniqueParts(int n, StringBuilder out) {
        int[] p = new int[n];
        int k = 0;
        p[k] = n;

        while (true) {

            printArray(p, k + 1, out);

            int rem_val = 0;
            while (k >= 0 && p[k] == 1) {
                rem_val += p[k];
                k--;
            }

            if (k < 0) {
                out.setLength(out.length() - 1);
                return;
            }

            p[k]--;
            rem_val++;

            while (rem_val > p[k]) {
                p[k + 1] = p[k];
                rem_val = rem_val - p[k];
                k++;
            }

            p[k + 1] = rem_val;
            k++;
        }
    }
}
