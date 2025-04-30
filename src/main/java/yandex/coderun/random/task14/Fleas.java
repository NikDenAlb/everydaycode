package yandex.coderun.random.task14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/fleas">task link</a><br>
 * test - OK
 */
public class Fleas {
    static boolean[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmstq = reader.readLine().split(" ");
        int n = Integer.parseInt(nmstq[0]);
        int m = Integer.parseInt(nmstq[1]);
        int s = Integer.parseInt(nmstq[2]) - 1;
        int t = Integer.parseInt(nmstq[3]) - 1;
        int q = Integer.parseInt(nmstq[4]);
        field = new boolean[n][m];
        for (int i = 0; i < q; i++) {
            String[] xy = reader.readLine().split(" ");
            field[Integer.parseInt(xy[0]) - 1][Integer.parseInt(xy[1]) - 1] = true;
        }

        boolean[][] visited = new boolean[n][m];
        visited[s][t] = true;

        List<Coord> curStep = new ArrayList<>(List.of(new Coord(s, t)));
        int count = 1;
        int sum = 0;
        int qCount = field[s][t] ? 1 : 0;

        while (!curStep.isEmpty()) {
            List<Coord> nextStep = new ArrayList<>();
            for (Coord curCoord : curStep) {
                List<Coord> moves = curCoord.moves();
                for (Coord move : moves) {
                    if (!visited[move.x][move.y]) {
                        visited[move.x][move.y] = true;
                        if (field[move.x][move.y]) {
                            sum += count;
                            qCount++;
                        }
                        nextStep.add(move);
                    }
                }
            }
            count++;
            curStep = nextStep;
        }

        writer.write(qCount == q ? String.valueOf(sum) : "-1");


        reader.close();
        writer.close();
    }

    record Coord(int x, int y) {
        /*
                  y-->

        x    [ ][2][ ][3][ ]
        |    [1][ ][ ][ ][4]
        ↓    [ ][ ][K][ ][ ]
             [8][ ][ ][ ][5]
             [ ][7][ ][6][ ]
         */
        List<Coord> moves() {
            List<Coord> moves = new ArrayList<>();
            //1
            if (x - 1 >= 0 && y - 2 >= 0) {
                moves.add(new Coord(x - 1, y - 2));
            }
            //2
            if (x - 2 >= 0 && y - 1 >= 0) {
                moves.add(new Coord(x - 2, y - 1));
            }
            //3
            if (x - 2 >= 0 && y + 1 < field[0].length) {
                moves.add(new Coord(x - 2, y + 1));
            }
            //4
            if (x - 1 >= 0 && y + 2 < field[0].length) {
                moves.add(new Coord(x - 1, y + 2));
            }
            //5
            if (x + 1 < field.length && y + 2 < field[0].length) {
                moves.add(new Coord(x + 1, y + 2));
            }
            //6
            if (x + 2 < field.length && y + 1 < field[0].length) {
                moves.add(new Coord(x + 2, y + 1));
            }
            //7
            if (x + 2 < field.length && y - 1 >= 0) {
                moves.add(new Coord(x + 2, y - 1));
            }
            //8
            if (x + 1 < field.length && y - 2 >= 0) {
                moves.add(new Coord(x + 1, y - 2));
            }
            return moves;
        }
    }
}
