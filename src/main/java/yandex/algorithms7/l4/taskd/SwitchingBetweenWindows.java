import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class SwitchingBetweenWindows {
    static StringBuilder out = new StringBuilder();
    static List<String> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = reader.readLine();
            if (cmd.charAt(0) == 'R') {
                add(cmd.length() > 3 ? cmd.substring(4) : "");
            } else {
                up(countPlus(cmd) % stack.size());
            }
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void add(String name) {
        stack.add(name);
        out.append(stack.getLast()).append('\n');
    }

    static void up(int pos) {
        String upElem = stack.get(stack.size() - pos - 1);
        stack.remove(stack.size() - pos - 1);
        stack.add(upElem);
        out.append(upElem).append('\n');
    }

    static int countPlus(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                count++;
            }
        }
        return count;
    }
}
