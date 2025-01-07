package yandex.internship260824backend.taska;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * test - Ok
 */
public class CrosswordSolver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = reader.readLine().split(" ");
        int r = Integer.parseInt(nums[0]);
        int c = Integer.parseInt(nums[1]);

        char[][] body = new char[r][c];
        for (int i = 0; i < r; i++) {
            body[i] = reader.readLine().toCharArray();
        }

        reader.close();

        System.out.println(crosswordSolver(r, c, body));
    }

    /**
     * @param r    количество строк
     * @param c    количество столбцов
     * @param body тело кроссворда
     * @return минимальное лексикографическое слово в 2 и более символов
     */
    public static String crosswordSolver(int r, int c, char[][] body) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (body[i][j] != '#') {
                    word.append(body[i][j]);
                } else {
                    if (word.length() > 1) {
                        words.add(word.toString());
                    }
                    word.setLength(0);
                }
            }
            if (word.length() > 1) {
                words.add(word.toString());
            }
            word.setLength(0);
        }

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (body[i][j] != '#') {
                    word.append(body[i][j]);
                } else {
                    if (word.length() > 1) {
                        words.add(word.toString());
                    }
                    word.setLength(0);
                }
            }
            if (word.length() > 1) {
                words.add(word.toString());
            }
            word.setLength(0);
        }

        Collections.sort(words);
        System.out.println(words);
        return words.get(0);
    }
}
