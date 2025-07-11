package leetcode.random.task994;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int orangesRotting(int[][] grid) {
        int cnt = 0;
        int frsh = 0;
        List<Coord> rots = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rots.add(new Coord(i, j));
                }
                if (grid[i][j] == 1) {
                    frsh++;
                }
            }
        }
        if (frsh == 0) {
            return 0;
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!rots.isEmpty()) {
            List<Coord> newRots = new ArrayList<>();
            for (Coord rot : rots) {
                for (int[] dir : dirs) {
                    int x = dir[0] + rot.x();
                    int y = dir[1] + rot.y();
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        newRots.add(new Coord(x, y));
                        grid[x][y] = 2;
                        frsh--;
                    }
                }
            }
            cnt++;
            if (frsh == 0) {
                return cnt;
            }
            rots = newRots;
        }
        return -1;
    }
}

record Coord(int x, int y) {
}