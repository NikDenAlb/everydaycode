package yandex.coderun.random.task45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/toy-maze">task link</a><br>
 * test - OK
 */
public class ToyMaze {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] maze = new int[n][];
        boolean[][] vd = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        List<Pos> cPos = new ArrayList<>();
        cPos.add(new Pos(0, 0));
        vd[0][0] = true;

        List<Pos> moves = List.of(
                new Pos(1, 0),
                new Pos(-1, 0),
                new Pos(0, 1),
                new Pos(0, -1));

        int count = 1;

        while (!cPos.isEmpty()) {
            List<Pos> nPos = new ArrayList<>();

            for (Pos pos : cPos) {
                for (Pos move : moves) {
                    Pos pointer = new Pos(pos.x, pos.y);
                    while (true) {
                        int nextX = pointer.x + move.x;
                        int nextY = pointer.y + move.y;

                        if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0 || maze[nextX][nextY] == 1) {
                            if (!vd[pointer.x][pointer.y]) {
                                nPos.add(pointer);
                                vd[pointer.x][pointer.y] = true;
                            }
                            break;
                        } else if (maze[nextX][nextY] == 0) {
                            pointer.move(move);
                        } else {
                            writer.write(String.valueOf(count));
                            reader.close();
                            writer.close();
                            return;
                        }
                    }
                }
            }
            count++;
            cPos = nPos;
        }

        writer.write("-1");

        reader.close();
        writer.close();
    }
}

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(Pos move) {
        x += move.x;
        y += move.y;
    }
}
