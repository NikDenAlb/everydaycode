package yandex.coderun.random.task34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/space-scavenger">task link</a><br>
 * test - OK
 */
public class SpaceScavenger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rules = new String[6];
        for (int i = 0; i < 6; i++) {
            rules[i] = reader.readLine();
        }
        String command = reader.readLine();
        char startDir = command.charAt(0);
        int prm = Integer.parseInt(command.substring(2));

        int[][] dp = new int[6][101];
        for (int p = 1; p <= prm; p++) {
            for (int d = 0; d < 6; d++) {
                if (p == 1) {
                    dp[d][p] = 1;
                } else {
                    dp[d][p] = 1;
                    for (char c : rules[d].toCharArray()) {
                        dp[d][p] += dp[mapToInd(c)][p - 1];
                    }
                }
            }
        }

        writer.write(String.valueOf(dp[mapToInd(startDir)][prm]));

        reader.close();
        writer.close();
    }

    static int mapToInd(char c) {
        return switch (c) {
            case 'N' -> 0;
            case 'S' -> 1;
            case 'W' -> 2;
            case 'E' -> 3;
            case 'U' -> 4;
            case 'D' -> 5;
            default -> throw new RuntimeException();
        };
    }
}
