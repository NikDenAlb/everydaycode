package yandex.coderun.random.task434;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//TODO 4+4+2+1 need to add

public class SplittingIntoTerms {
    public static void main(String[] args) throws IOException {
        String inputtxt = "src/main/java/yandex/coderun/random/task434/input.txt";
        String outputtxt = "src/main/java/yandex/coderun/random/task434/output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputtxt));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputtxt));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();

        int[] terms = new int[n];
        Arrays.fill(terms, 1);
        int length = n;

        do {
            for (int i = 0; i < length; i++) {
                out.append(terms[i]).append(" + ");
            }
            out.setLength(out.length() - 3);
            out.append('\n');
            boolean flag = false;
            for (int i = length - 2; i > 0; i--) {
                if (terms[i - 1] > terms[i]) {
                    terms[i]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                terms[0]++;
            }
            terms[length - 1]--;
            if (terms[length - 1] == 0) {
                length--;
            }
        } while (terms[0] < n);
        if (n != 1) {
            out.append(n);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
