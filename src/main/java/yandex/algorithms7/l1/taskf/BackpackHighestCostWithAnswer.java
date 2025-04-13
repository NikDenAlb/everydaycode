import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BackpackHighestCostWithAnswer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxM = Integer.parseInt(reader.readLine().split(" ")[1]);
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][][] bp = new int[m.length][maxM + 1][2];

        for (int i = 0; i < m.length; i++) {
            if (i > 0) {
                bp[i] = bp[i - 1].clone();
                for (int i1 = 0; i1 < bp[i].length; i1++) {
                    bp[i][i1] = bp[i - 1][i1].clone();
                }
            }
            for (int j = bp[i].length - 1 - m[i]; j > 0; j--) {
                if (bp[i][j][0] > 0) {
                    if (bp[i][j][0] + c[i] > bp[i][j + m[i]][0]) {
                        bp[i][j + m[i]][0] = bp[i][j][0] + c[i];
                        bp[i][j + m[i]][1] = i;
                    }
                }
            }
            if (m[i] < bp[i].length) {
                if (c[i] > bp[i][m[i]][0]) {
                    bp[i][m[i]][0] = c[i];
                    bp[i][m[i]][1] = i;
                }
            }
        }

        int maxC = Arrays.stream(bp[bp.length - 1]).mapToInt(e -> e[0]).max().orElseThrow();

        List<Integer> ans = new ArrayList<>();

        for (int i = m.length - 1; maxC > 0; i--) {
            for (int j = maxM; j > 0; j--) {
                if (bp[i][j][0] == maxC) {
                    i = bp[i][j][1];
                    ans.add(i + 1);
                    maxC -= c[i];
                    maxM -= m[i];
                    break;
                }
            }
        }

        Collections.reverse(ans);

        writer.write(ans.stream().map(String::valueOf).collect(Collectors.joining("\n")));

        reader.close();
        writer.close();
    }
}
