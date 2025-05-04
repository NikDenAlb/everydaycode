import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WeakLinkTL2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] pls = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] outPls = new boolean[n];

        boolean flag = true;
        int round = 1;
        int count = n;

        while (count > 2 && flag) {
            flag = false;
            int l = n - 1, m = 0, r, end, start;
            while (outPls[l]) {
                l--;
            }
            end = l;
            while (outPls[m]) {
                m++;
            }
            start = m;
            r = m + 1;
            while (outPls[r]) {
                r++;
            }
            if (pls[m] < pls[l] && pls[m] < pls[r]) {
                outPls[m] = true;
                pls[m] = round;
                flag = true;
                count--;
            }
            l = m;
            m = r;
            r++;

            while (r <= end) {
                if (!outPls[r]) {
                    if (pls[m] < pls[l] && pls[m] < pls[r]) {
                        outPls[m] = true;
                        pls[m] = round;
                        flag = true;
                        count--;
                    }
                    l = m;
                    m = r;
                }
                r++;
            }
            r = start;
            if (pls[m] < pls[l] && pls[m] < pls[r]) {
                outPls[m] = true;
                pls[m] = round;
                flag = true;
                count--;
            }
            round++;
        }

        if (count > 0) {
            for (int i = 0; i < pls.length; i++) {
                if (!outPls[i]) {
                    pls[i] = 0;
                }
            }
        }

        writer.write(Arrays.stream(pls).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
