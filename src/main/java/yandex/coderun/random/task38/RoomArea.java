package yandex.coderun.random.task38;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/room-area">task link</a><br>
 * test - OK
 */
public class RoomArea {
    static List<List<Boolean>> field;
    static boolean[][] vstd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        field = new ArrayList<>(n);
        vstd = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            field.add(reader.readLine().chars().mapToObj(c -> c == '.').toList());
        }
        String[] line = reader.readLine().split(" ");
        Coord start = new Coord(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1);
        vstd[start.x][start.y] = true;

        List<Coord> curStep = new ArrayList<>(List.of(start));
        int count = 1;

        while (!curStep.isEmpty()) {
            List<Coord> nextStep = new ArrayList<>();
            for (Coord curCoord : curStep) {
                List<Coord> moves = curCoord.moves();
                for (Coord move : moves) {
                    vstd[move.x][move.y] = true;
                    nextStep.add(move);
                }
            }
            count += nextStep.size();
            curStep = nextStep;
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }

    record Coord(int x, int y) {
        /*
                    y ->
                [ ][2][ ]
             x  [1][*][3]
             ↓  [ ][4][ ]
        */
        List<Coord> moves() {
            List<Coord> moves = new ArrayList<>();
            //1
            if (field.get(x).get(y - 1) && !vstd[x][y - 1]) {
                moves.add(new Coord(x, y - 1));
            }
            //2
            if (field.get(x - 1).get(y) && !vstd[x - 1][y]) {
                moves.add(new Coord(x - 1, y));
            }
            //3
            if (field.get(x).get(y + 1) && !vstd[x][y + 1]) {
                moves.add(new Coord(x, y + 1));
            }
            //4
            if (field.get(x + 1).get(y) && !vstd[x + 1][y]) {
                moves.add(new Coord(x + 1, y));
            }
            return moves;
        }
    }
}
