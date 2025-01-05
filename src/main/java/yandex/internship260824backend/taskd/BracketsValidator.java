package yandex.internship260824backend.taskd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsValidator {
    public static void main(String[] args) throws Exception {
        int MOD = 1000000007;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String sequence = reader.readLine();

        reader.close();

        if (n % 2 == 1) { //fastValidation
            System.out.println(0);
        }

        System.out.println(bracketsValidator(n, sequence, new ArrayDeque<>(), 0) % MOD);
    }

    /**
     * @param n длина последовательности
     * @param sequence последовательность
     * @param stack накопленная очередь (пустая для первого вызова)
     * @param startIndex индекс входа (0 - для первого вызова)
     * @return количество способов заменить знаки `?` на скобки
     */
    public static long bracketsValidator(int n, String sequence, Deque<Character> stack, int startIndex) {
        for (int i = startIndex; i < n; i++) {
            char currChar = sequence.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else if (currChar == ')' || currChar == ']' || currChar == '}') {
                if (stack.isEmpty()) {
                    return 0;
                }
                if (!isMatchingPair(stack.pop(), currChar)) {
                    return 0;
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(currChar);
                    return bracketsValidator(n, sequence, stack, i + 1);
                }
                Deque<Character> stackPush = new ArrayDeque<>(stack);
                stackPush.push(currChar);
                char charPop = stack.pop();
                return bracketsValidator(n, sequence, stack, i + 1) * (charPop == '?' ? 3 : 1)
                        + bracketsValidator(n, sequence, stackPush, i + 1);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    private static boolean isMatchingPair(char e1, char e2) {
        return (e1 == '?') ||
                (e1 == '(' && e2 == ')') ||
                (e1 == '[' && e2 == ']') ||
                (e1 == '{' && e2 == '}');
    }
}
