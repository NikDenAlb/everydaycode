package yandex.summer.stageone.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();//N
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = 1;

        for (int i = 0; (i + 1) / 2 < a.length; i++) {
            int sL = i / 2;
            int sR = (i + 1) / 2;
            int cC = i % 2 - 1;

            for (int l = sL, r = sR; l >= 0 && r < a.length; l--, r++) {
                if (a[l] == a[r]) {
                    cC += 2;
                } else {
                    len = Math.max(len, cC);
                    break;
                }
                if (l == 0 || r == a.length - 1) {
                    len = Math.max(len, cC);
                }
            }
        }

        if (len == 1) {
            len = 0;
        }

        writer.write(String.valueOf(len));

        reader.close();
        writer.close();
    }
}
