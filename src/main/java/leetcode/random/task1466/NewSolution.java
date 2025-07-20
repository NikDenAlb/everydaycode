package leetcode.random.task1466;

import java.util.ArrayList;
import java.util.List;

class NewSolution {
    List<List<Integer>> roads;
    boolean[] vstd;
    int cnt;

    int minReorder(int n, int[][] connections) {
        roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<>());
        }
        vstd = new boolean[n];
        cnt = 0;
        for (int[] conn : connections) {
            roads.get(conn[0]).add(conn[1]);
            roads.get(conn[1]).add(-conn[0]);
        }
        dfs(0);
        return cnt;
    }

    void dfs(int a) {
        vstd[a] = true;
        for (int c : roads.get(a)) {
            if (c > 0) {
                if (!vstd[c]) {
                    cnt++;
                    dfs(c);
                }
            } else {
                if (!vstd[-c]) {
                    dfs(-c);
                }
            }
        }
    }
}