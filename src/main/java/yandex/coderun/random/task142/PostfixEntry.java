package yandex.coderun.random.task142;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/problem/postfix-entry">task link</a><br>
 * test - OK
 */
public class PostfixEntry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : input) {
            stack.push(s);
        }

        writer.write(String.valueOf(operate(stack)));

        reader.close();
        writer.close();
    }

    static int operate(Deque<String> stack) {
        String e = stack.pop();
        return switch (e) {
            case "+" -> operate(stack) + operate(stack);
            case "-" -> -operate(stack) + operate(stack);
            case "*" -> operate(stack) * operate(stack);
            default -> Integer.parseInt(e);
        };
    }
}
