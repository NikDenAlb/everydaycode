package leetcode.random.task1926;

import java.util.ArrayDeque;
import java.util.Queue;

class EasySolution {
    int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> ways = new ArrayDeque<>();
        ways.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int steps = 0;
        int x, y;
        while (!ways.isEmpty()) {
            steps++;
            int n = ways.size();
            for (int i = 0; i < n; i++) {
                int[] current = ways.poll();

                for (int[] dir : dirs) {
                    x = current[0] + dir[0];
                    y = current[1] + dir[1];

                    if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
                        return steps;
                    }
                    maze[x][y] = '+';
                    ways.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
