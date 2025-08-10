package yandex.coderun.random.task19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/the-value-of-a-boolean-expression">task link</a><br>
 * test - OK
 */
class TheValueOfABooleanExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(calculate(reader.readLine())));

        reader.close();
        writer.close();
    }

    static int calculate(String expression) {
        return parseExpression(expression, new int[]{0});
    }

    static int parseExpression(String expr, int[] pos) {
        int val = parseAnd(expr, pos);
        while (pos[0] < expr.length()) {
            char op = expr.charAt(pos[0]);
            if (op != '|' && op != '^') {
                break;
            }
            pos[0]++;
            int right = parseAnd(expr, pos);
            if (op == '|') {
                val = (val != 0 || right != 0) ? 1 : 0;
            } else {
                val = (val != right) ? 1 : 0;
            }
        }
        return val;
    }

    static int parseAnd(String expr, int[] pos) {
        int val = parseFactor(expr, pos);
        while (pos[0] < expr.length()) {
            char op = expr.charAt(pos[0]);
            if (op != '&') {
                break;
            }
            pos[0]++;
            int right = parseFactor(expr, pos);
            val = (val != 0 && right != 0) ? 1 : 0;
        }
        return val;
    }

    static int parseFactor(String expr, int[] pos) {
        char c = expr.charAt(pos[0]);
        if (c == '!') {
            pos[0]++;
            int inner = parseFactor(expr, pos);
            return (inner == 0) ? 1 : 0;
        } else if (c == '0' || c == '1') {
            pos[0]++;
            return c - '0';
        } else if (c == '(') {
            pos[0]++;
            int val = parseExpression(expr, pos);
            pos[0]++;
            return val;
        }
        throw new RuntimeException();
    }
}