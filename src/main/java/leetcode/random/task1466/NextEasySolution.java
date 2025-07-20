package leetcode.random.task1466;

import java.util.Arrays;

public class NextEasySolution {
    int out;
    boolean[] vstd;
    int[] ctd;

    int minReorder(int n, int[][] connections) {
        out = 0;
        vstd = new boolean[n];
        vstd[0] = true;
        ctd = new int[n];
        Arrays.fill(ctd, Integer.MAX_VALUE);
        for (int[] e : connections) {
            if (ctd[e[0]] == Integer.MAX_VALUE) {
                ctd[e[0]] = e[1];
            } else {
                ctd[e[1]] = -e[0];
            }
        }
        dfs(0);
        return out;
    }

    void dfs(int city) {
        for (int i = 0; i < vstd.length; i++) {
            if (!vstd[i]) {
                if (ctd[i] == city && ctd[city] == -i) {
                    vstd[i] = true;
                    dfs(i);
                } else if (ctd[i] == -city && ctd[city] == i) {
                    out++;
                    vstd[i] = true;
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        NextEasySolution solution = new NextEasySolution();
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(solution.minReorder(6, connections));
    }
}
