package leetcode.random.task1466;

class MLEasySolution {
    int out;
    boolean[] vstd;
    boolean[][] mtx;

    int minReorder(int n, int[][] connections) {
        out = 0;
        vstd = new boolean[n];
        vstd[0] = true;
        mtx = new boolean[n][n];
        for (int[] e : connections) {
            mtx[e[0]][e[1]] = true;
        }
        dfs(0);
        return out;
    }

    void dfs(int city) {
        for (int i = 0; i < vstd.length; i++) {
            if (!vstd[i]) {
                if (mtx[i][city]) {
                    vstd[i] = true;
                    dfs(i);
                } else if (mtx[city][i]) {
                    out++;
                    vstd[i] = true;
                    dfs(i);
                }
            }
        }
    }
}
