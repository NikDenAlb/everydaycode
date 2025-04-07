package yandex.coderun.random.task133;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/control-work">task link</a><br>
 * test - OK
 */
public class ControlWork {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int pRow = Integer.parseInt(reader.readLine());
        int p12 = Integer.parseInt(reader.readLine());

        writer.write(findPlace(n, k, pRow, p12));

        reader.close();
        writer.close();
    }

    static String findPlace(int n, int k, int pRow, int p12) {
        int p = (pRow - 1) * 2 + p12;

        if (p + k > n && p - k < 1) {
            return "-1";
        }

        int vRow, v12;
        if (p + k > n) {
            vRow = (p - k + 1) / 2;
            v12 = ((p - k) % 2 == 0) ? 2 : 1;
        } else if (p - k < 1) {
            vRow = (p + k + 1) / 2;
            v12 = ((p + k) % 2 == 0) ? 2 : 1;
        } else {
            int vRowU = (p + k + 1) / 2;
            int vRowD = (p - k + 1) / 2;
            boolean up = vRowU - pRow <= pRow - vRowD;
            vRow = (up) ? vRowU : vRowD;
            v12 = (up)
                    ? ((p + k) % 2 == 0) ? 2 : 1
                    : ((p - k) % 2 == 0) ? 2 : 1;
        }

        return vRow + " " + v12;
    }
}
