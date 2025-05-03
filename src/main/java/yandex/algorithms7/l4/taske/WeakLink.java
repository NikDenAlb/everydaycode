import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeakLink {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] pls = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] leftWeak = new boolean[n];
        boolean[] rightWeak = new boolean[n];
        int[] ans = new int[n];
        int[] leftPls = new int[n];
        int[] rightPls = new int[n];
        List<Integer> weaklings = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            leftWeak[i] = pls[i] < pls[i - 1];
            rightWeak[i] = pls[i] < pls[i + 1];
            if (leftWeak[i] && rightWeak[i]) {
                weaklings.add(i);
            }
            leftPls[i] = i - 1;
            rightPls[i] = i + 1;
        }
        leftWeak[0] = pls[0] < pls[n - 1];
        rightWeak[0] = pls[0] < pls[1];
        if (leftWeak[0] && rightWeak[0]) {
            weaklings.add(0);
        }
        leftPls[0] = n - 1;
        rightPls[0] = 1;
        leftWeak[n - 1] = pls[n - 1] < pls[n - 2];
        rightWeak[n - 1] = pls[n - 1] < pls[0];
        if (leftWeak[n - 1] && rightWeak[n - 1]) {
            weaklings.add(n - 1);
        }
        leftPls[n - 1] = n - 2;
        rightPls[n - 1] = 0;

        for (int round = 1; !weaklings.isEmpty() && n > 2; round++) {
            List<Integer> newWeaklings = new ArrayList<>();
            n -= weaklings.size();
            for (Integer w : weaklings) {
                int lInd = leftPls[w];
                int rInd = rightPls[w];
                rightPls[lInd] = rInd;
                leftPls[rInd] = lInd;

                rightWeak[lInd] = pls[lInd] < pls[rInd];
                leftWeak[rInd] = pls[rInd] < pls[lInd];

                if (rightWeak[lInd] && leftWeak[lInd]) {
                    newWeaklings.add(lInd);
                }
                if (rightWeak[rInd] && leftWeak[rInd]) {
                    newWeaklings.add(rInd);
                }
                ans[w] = round;
            }
            weaklings = newWeaklings;
        }

        writer.write(Arrays.stream(ans).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
