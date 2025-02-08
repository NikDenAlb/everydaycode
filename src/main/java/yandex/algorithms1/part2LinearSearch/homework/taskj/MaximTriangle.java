package yandex.algorithms1.part2LinearSearch.homework.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * test - OK
 */
public class MaximTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        double[] notes = new double[n];
        boolean[] further = new boolean[n - 1];
        notes[0] = Double.parseDouble(reader.readLine());

        for (int i = 1; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            notes[i] = Double.parseDouble(line[0]);
            further[i - 1] = line[1].equals("further");
        }

        writer.write(findRange(notes, further));

        reader.close();
        writer.close();
    }

    static String findRange(double[] notes, boolean[] further) {
        double min = 30;
        double max = 4000;
        for (int i = 0; i < further.length; i++) {
            if (!further[i]) {
                if (notes[i + 1] < notes[i]) {
                    max = Math.min((notes[i + 1] + notes[i]) / 2, max);
                }
                if (notes[i + 1] > notes[i]) {
                    min = Math.max((notes[i + 1] + notes[i]) / 2, min);
                }
            } else {
                if (notes[i + 1] < notes[i]) {
                    min = Math.max((notes[i + 1] + notes[i]) / 2, min);
                }
                if (notes[i + 1] > notes[i]) {
                    max = Math.min((notes[i + 1] + notes[i]) / 2, max);
                }
            }
        }
        return min + " " + max;
    }
}
