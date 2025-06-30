package leetcode.random.task547;

class EasySolution {
    boolean[] vstd;

    int findCircleNum(int[][] isConnected) {
        vstd = new boolean[isConnected.length];
        int out = 0;
        for (int i = 0; i < vstd.length; i++) {
            if (!vstd[i]) {
                bfs(isConnected, i);
                out++;
            }
        }
        return out;
    }

    void bfs(int[][] isConnected, int sity) {
        vstd[sity] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (!vstd[j] && isConnected[sity][j] == 1) {
                bfs(isConnected, j);
            }
        }
    }
}
