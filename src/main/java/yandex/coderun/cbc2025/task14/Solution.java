package yandex.coderun.cbc2025.task14;

import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/playing-field">task link</a><br>
 * test - OK
 */
class Solution {
    public static class Answer {
        public int sum;
        public String[] field;

        public Answer(int sum, String[] field) {
            this.sum = sum;
            this.field = field;
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "sum=" + sum +
                    ", field=" + Arrays.toString(field) +
                    '}';
        }
    }

    public static Answer solution(int n) {
        if (n < 3) {

            StringBuilder line1 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                line1.append((i % 2 == 0) ? 'x' : '-');
            }
            StringBuilder line2 = new StringBuilder(line1.substring(1, line1.length()));
            line2.append(n % 2 == 0 ? 'x' : '-');
            String[] field = new String[n];
            for (int i = 0; i < field.length; i++) {
                field[i] = i % 2 == 0 ? line1.toString() : line2.toString();
            }
            return new Answer(2 * n * (n - 1), field);
        }

        if (n % 2 == 1) {
            String line0 = "-".repeat(n);
            String line1 = "x".repeat(n);
            String[] field = new String[n];
            for (int i = 0; i < field.length; i++) {
                field[i] = i % 2 == 0 ? line0 : line1;
            }
            return new Answer((8 + 6 * (n - 2)) * (n / 2), field);
        }
        String line0 = "-".repeat(n);
        String line1 = "x".repeat(n);
        String[] field = new String[n];
        for (int i = 0; i < field.length; i++) {
            field[i] = i % 2 == 0 ? line0 : line1;
        }
        return new Answer((4 + 3 * (n - 2)) * (n - 1), field);
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(7));
    }
}
