import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeakLinkTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] players = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Player> list = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            list.add(new Player(players[i], i));
        }

        boolean flag = true;
        int round = 1;
        while (list.size() > 2 && flag) {
            flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).power() < list.get((i + list.size() - 1) % list.size()).power() && list.get(i).power() < list.get((i + 1) % list.size()).power()) {
                    players[list.get(i).position()] = round;
                    list.remove(i);
                    flag = true;
                }
            }
            round++;
        }
        for (Player player : list) {
            players[player.position()] = 0;
        }

        writer.write(Arrays.stream(players).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}

//record Player(int power, int position) {
//}

class Player {
    int position;
    int power;

    public Player(int power, int position) {
        this.power = power;
        this.position = position;
    }

    public int power() {
        return power;
    }

    public int position() {
        return position;
    }
}
