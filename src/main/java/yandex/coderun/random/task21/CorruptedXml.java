package yandex.coderun.random.task21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <a href="https://coderun.yandex.ru/problem/corrupted-xml">task link</a><br>
 * test - OK
 */
public class CorruptedXml {
    public static boolean isValid(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) != '<') return false;
            i++;
            boolean isClosing = false;
            if (i < s.length() && s.charAt(i) == '/') {
                isClosing = true;
                i++;
            }
            StringBuilder tag = new StringBuilder();
            while (i < s.length() && Character.isLowerCase(s.charAt(i))) {
                tag.append(s.charAt(i));
                i++;
            }
            if (tag.isEmpty()) return false;
            if (i >= s.length() || s.charAt(i) != '>') return false;
            i++;
            if (isClosing) {
                if (stack.isEmpty() || !stack.peek().equals(tag.toString())) return false;
                stack.pop();
            } else {
                stack.push(tag.toString());
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = reader.readLine().toCharArray();

        Set<Character> set = Stream.concat(IntStream.rangeClosed('a', 'z')
                        .mapToObj(c -> (char) c), Stream.of('<', '>', '/'))
                .collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++) {
            char oldC = arr[i];
            for (char ch : set) {
                if (ch == oldC) continue;
                arr[i] = ch;
                String temp = new String(arr);
                if (isValid(temp)) {
                    System.out.println(temp);
                    return;
                }
            }
            arr[i] = oldC;
        }

        reader.close();
        writer.close();
    }
}
