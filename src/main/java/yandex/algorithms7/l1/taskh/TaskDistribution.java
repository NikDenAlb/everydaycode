import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
even

------------------------------------------------------------------------------------------

odd
 */
public class TaskDistribution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int unFlipOnlyEven = 0;
        int unFlipMax = 0;
        int flipCommon = 0;
        List<Integer> flip = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            int eC = 0;
            int oC = 0;
            boolean flag = input.length() % 2 == 0;

            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                if (currentChar == 'S') {
                    if (j % 2 == 0) {
                        eC++;
                    } else {
                        oC++;
                    }
                }
            }
            if (flag) {
                unFlipOnlyEven += eC;
                unFlipMax += Math.max(eC, oC);
            } else {
                flip.add(eC - oC);
                flipCommon += Math.min(eC, oC);
            }
        }

        int out = 0;
        out += flip.isEmpty() ? unFlipOnlyEven : unFlipMax;
        out += flipCommon;

        Collections.sort(flip);

        for (int i = 0; i < flip.size(); i++) {
            if (i % 2 == 0) {
                out += Math.max(flip.get(flip.size() - 1 - (i / 2)), 0);
            } else {
                out -= Math.min(flip.get(i / 2), 0);
            }
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}
