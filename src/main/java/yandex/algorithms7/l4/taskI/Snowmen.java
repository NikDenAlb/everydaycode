package yandex.algorithms7.l4.taskI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snowmen {
    static List<Child> list = new ArrayList<>(List.of(new Child(0, 0)));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in),8388608);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            execute(reader.readLine());
        }

        writer.write(String.valueOf(list.stream().map(Child::m).mapToLong(Long::longValue).sum()));

        reader.close();
        writer.close();
    }

    static void execute(String cmd) {
        int[] subCmds = Arrays.stream(cmd.split(" ")).mapToInt(Integer::parseInt).toArray();
        if (subCmds[1] == 0) {
            headCut(subCmds[0]);
        } else {
            add(subCmds[0], subCmds[1]);
        }
    }

    static void add(int i, long m) {
        list.add(new Child(i, list.get(i).m() + m));
    }

    static void headCut(int i) {
        list.add(new Child(list.get(list.get(i).parent()).parent(), list.get(list.get(i).parent()).m()));
    }
}

record Child(int parent, long m) {
}
