package yandex.coderun.quickstart.task15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/determine-type-sequence">task link</a><br>
 * test - OK
 */
public class DetermineTypeSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> inputList = new ArrayList<>();
        int input = Integer.parseInt(reader.readLine());
        while (input != -2_000_000_000) {
            inputList.add(input);
            input = Integer.parseInt(reader.readLine());
        }
        int[] sequence = inputList.stream().mapToInt(i -> i).toArray();
        writer.write(defineSequence(sequence));

        reader.close();
        writer.close();
    }

    public static String defineSequence(int[] sequence) {
        boolean constant = true;
        boolean ascending = true;
        boolean weaklyAscending = true;
        boolean descending = true;
        boolean weaklyDescending = true;

        for (int i = 1; i < sequence.length; i++) {
            if (constant) if (sequence[i] != sequence[i - 1]) constant = false;
            if (ascending) if (sequence[i] <= sequence[i - 1]) ascending = false;
            if (weaklyAscending) if (sequence[i] < sequence[i - 1]) weaklyAscending = false;
            if (descending) if (sequence[i] >= sequence[i - 1]) descending = false;
            if (weaklyDescending) if (sequence[i] > sequence[i - 1]) weaklyDescending = false;
            if (!(constant || ascending || weaklyAscending || descending || weaklyDescending)) return "RANDOM";
        }
        if (constant) return "CONSTANT";
        if (ascending) return "ASCENDING";
        if (descending) return "DESCENDING";
        if (weaklyAscending) return "WEAKLY ASCENDING";
        return "WEAKLY DESCENDING";
    }
}
