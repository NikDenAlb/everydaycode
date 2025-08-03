package yandex.coderun.random.task18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/problem/the-value-of-an-arithmetic-expression">task link</a><br>
 * test - OK
 */
class TheValueOfAnArithmeticExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        Deque<Integer> values = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        char lastType = '(';

        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(ch)) {
                if (lastType == ')' || Character.isDigit(lastType)) {
                    writer.write("WRONG");
                    writer.close();
                    reader.close();
                    return;
                }
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                values.addLast(num);
                lastType = '0';
                continue;
            } else if (ch == '(') {
                if (lastType == ')' || Character.isDigit(lastType)) {
                    writer.write("WRONG");
                    writer.close();
                    reader.close();
                    return;
                }
                ops.addLast('(');
                lastType = '(';
            } else if (ch == ')') {
                if (!Character.isDigit(lastType) && lastType != ')') {
                    writer.write("WRONG");
                    writer.close();
                    reader.close();
                    return;
                }
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    if (doOp(values, ops)) {
                        writer.write("WRONG");
                        writer.close();
                        reader.close();
                        return;
                    }
                }
                if (ops.isEmpty()) {
                    writer.write("WRONG");
                    writer.close();
                    reader.close();
                    return;
                }
                ops.removeLast();
                lastType = ')';
            } else if (ch == '+' || ch == '-' || ch == '*') {
                if (!Character.isDigit(lastType) && lastType != ')') {
                    writer.write("WRONG");
                    writer.close();
                    reader.close();
                    return;
                }
                while (!ops.isEmpty() && ops.peekLast() != '(' && getPriority(ops.peekLast()) >= getPriority(ch)) {
                    if (doOp(values, ops)) {
                        writer.write("WRONG");
                        writer.close();
                        reader.close();
                        return;
                    }
                }
                ops.addLast(ch);
                lastType = ch;
            } else {
                writer.write("WRONG");
                writer.close();
                reader.close();
                return;
            }
            i++;
        }

        while (!ops.isEmpty()) {
            if (ops.peekLast() == '(' || doOp(values, ops)) {
                writer.write("WRONG");
                writer.close();
                reader.close();
                return;
            }
        }

        if (values.size() != 1) {
            writer.write("WRONG");
        } else {
            writer.write(String.valueOf(values.peekLast()));
        }

        reader.close();
        writer.close();
    }

    static int getPriority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*') {
            return 2;
        }
        return 0;
    }

    static boolean doOp(Deque<Integer> values, Deque<Character> ops) {
        if (values.size() < 2 || ops.isEmpty()) {
            return true;
        }
        int r = values.removeLast();
        int l = values.removeLast();
        char op = ops.removeLast();
        if (op == '+') {
            values.addLast(l + r);
        } else if (op == '-') {
            values.addLast(l - r);
        } else if (op == '*') {
            values.addLast(l * r);
        } else {
            return true;
        }
        return false;
    }
}
