package yandex.coderun.hrtechinterview.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/correct-bracket-sequence">task link</a><br>
 * test - OK
 */
public class CorrectBracketSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        if (isCorrectBracketSequence(reader.readLine())) {
            writer.write("yes");
        } else {
            writer.write("no");
        }

        reader.close();
        writer.close();
    }

    static boolean isCorrectBracketSequence(String sequence) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(' || sequence.charAt(i) == '[' || sequence.charAt(i) == '{') {
                stack.push(sequence.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char poll = stack.poll();

                if ((sequence.charAt(i) != ')' || poll != '(') &&
                        (sequence.charAt(i) != ']' || poll != '[') &&
                        (sequence.charAt(i) != '}' || poll != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
