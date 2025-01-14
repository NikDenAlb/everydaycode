package yandex.algorithms1.part2LinearSearch.homework.taskb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * test - OK: 155ms 16.36Mb
 */
public class Sequence {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> inputList = new ArrayList<>();
        while (true) {
            int input = Integer.parseInt(reader.readLine());
            if (input == -2_000_000_000) {
                break;
            }
            inputList.add(input);
        }
        int[] list = inputList.stream().mapToInt(Integer::intValue).toArray();

        reader.close();

        System.out.println(defineSequence(list));
    }

    /**
     * @return "CONSTANT"<br>"ASCENDING"<br>"DESCENDING"<br>"WEAKLY ASCENDING"<br>"WEAKLY DESCENDING"<br>"RANDOM"
     */
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
