/*
package yandex.coderun.random.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Cafe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] pays = new int[n];
        for (int i = 0; i < pays.length; i++) {
            pays[i] = Integer.parseInt(reader.readLine());
        }



/*
        [0]
        [1][?]
        [2][?][?]
        -----------
        [n-1][][][][][][][]
 //
        for (int i = 1; i < n; i++) {
            if (pays[i - 1] > 100) {
                dp[i] = new int[dp[i - 1].length + 1][];
            } else {
                dp[i] = new int[dp[i - 1].length][];
            }
            if (pays[i] > 100) {
                dp[i][0] = new int[]{dp[i - 1][0][0] + pays[i], dp[i - 1][0][1] + 1};
            } else {
                dp[i][0] = new int[]{dp[i - 1][0][0] + pays[i], dp[i - 1][0][1]};
            }
        }
/*
        pays[i-1]<=100&&pays[i]<=100       pays[i-1]<=100&&pays[i]>100
           [8]...[s][k]...[0]                 [8][ ]...[s][ ][k]...[0]
                    \|                            |      `---.|
           [8]...[ ][*]...[0]                 [9][ ]...[ ][ ][*]...[1]


        pays[i-1]>100&&pays[i]<=100        pays[i-1]>100&&pays[i]>100
           [8]...[s][k]...[1]                 [8][ ]...[s][ ][k]...[1]
                    \|                            |      `---.|
           [8]...[ ][*]...[ ][0]              [9][ ]...[ ][ ][*]...[ ][1]
//
        for (int i = 1; i < n; i++) {
            if (pays[i] <= 100) {
                for (int j = 1; j < dp[i - 1].length; j++) {
                    int payS = dp[i - 1][j - 1][0];
                    int payK = dp[i - 1][j][0] + pays[i];
                    if (payS < payK) {
                        dp[i][j] = Arrays.copyOf(dp[i - 1][j - 1], dp[i - 1][j - 1].length + 1);
                        dp[i][j][1]--;
                        dp[i][j][dp[i][j].length - 1] = i + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j].clone();
                        dp[i][j][0] = payK;
                    }
                }
                if (pays[i - 1] > 100) {
                    dp[i][dp[i].length - 1] = Arrays.copyOf(dp[i - 1][dp[i].length - 2], dp[i - 1][dp[i].length - 2].length + 1);
                    dp[i][dp[i].length - 1][1]--;
                    dp[i][dp[i].length - 1][dp[i][dp[i].length - 1].length - 1] = i + 1;
                }
            } else {
                if (dp[i].length > 1 && i > 1) {
                    dp[i][1] = dp[i - 1][1].clone();
                    dp[i][1][0] += pays[i];
                }
                for (int j = 2; j < dp[i - 1].length; j++) {
                    int payS = dp[i - 1][j - 2][0];
                    int payK = dp[i - 1][j][0] + pays[i];
                    if (payS < payK) {
                        dp[i][j] = Arrays.copyOf(dp[i - 1][j - 2], dp[i - 1][j - 2].length + 1);
                        dp[i][j][1]--;
                        dp[i][j][dp[i][j].length - 1] = i + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j].clone();
                        dp[i][j][0] = payK;
                        dp[i][j][1]++;
                    }
                    if (pays[i - 1] > 100) {
                        dp[i][dp[i].length - 1] = Arrays.copyOf(dp[i - 1][dp[i].length - 3], dp[i - 1][dp[i].length - 3].length + 1);
                        dp[i][dp[i].length - 1][1]--;
                        dp[i][dp[i].length - 1][dp[i][dp[i].length - 1].length - 1] = i + 1;
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        if (n > 0) {
            int[] ans = Arrays.stream(dp[n - 1]).min(Comparator.comparingInt((int[] e) -> e[0]).thenComparingInt(e -> -e[1])).orElseThrow();
            out.append(ans[0]).append("\n");
            out.append(ans[1]).append(' ').append(ans.length - 2).append("\n");
            for (int i = 2; i < ans.length; i++) {
                out.append(ans[i]).append("\n");
            }
        } else {
            out.append(0).append("\n");
            out.append(0).append(" ").append(0);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int[] findBestStrategy(int[] pays) {
//      [totalPay][CurrCoupons][dayCouponUsed][dayCouponUsed][dayCouponUsed]...
        if (pays.length == 0) {
            return new int[0];
        }

//      0[]
        int[][][] dp = new int[pays.length][][];
        dp[0] = new int[1][2];
        if (pays[0] > 100) {
            dp[0][0] = new int[]{pays[0], 1};
        } else {
            dp[0][0] = new int[]{pays[0], 0};
        }
        if (pays.length == 1) {
            return dp[0][0];
        }
/*
                  0[ ]                  special: [0]
                  1[ ][?]                        [1]            pay>100
                  2[ ][?][?]                     [2][*][0]      pay>100
        ------------------------------           [3][*][1][0]   pay>100
        pays.length[ ][][][][][][][]             [ ][ ]...[0]   when pay>100 is broken
//
        int pos = 1;
        boolean special = false;
        while (pos < pays.length) {
            if (pays[pos - 1] > 100 && pays[pos] > 100) {
                dp[pos] = new int[3][];
                dp[pos][0] = new int[] {dp[pos-1][0][0]+pays[pos],};
            }
        }
        for (int i = 1; i < pays.length; i++) {
            if (pays[i - 1] > 100 && pays[i] > 100 && dp[i - 1].length == 1) {
                dp[i] = new int[3][];
            } else if (pays[i - 1] > 100 && pays[i] > 100 && dp[i - 1].length == 2) {
                dp[i] = new int[dp[i - 1].length][];
            }


            if (pays[i] > 100) {
                dp[i][0] = new int[]{dp[i - 1][0][0] + pays[i], dp[i - 1][0][1] + 1};
            } else {
                dp[i][0] = new int[]{dp[i - 1][0][0] + pays[i], dp[i - 1][0][1]};
            }
        }


        return null;
    }
}
        */
