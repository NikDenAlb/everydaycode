package yandex.internship260824backend.taske;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - TL
 */
public class IneffectiveSearch {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = reader.readLine();
        }
        int q = Integer.parseInt(reader.readLine());
        String[] requests = new String[n];
        for (int i = 0; i < q; i++) {
            requests[i] = reader.readLine();
        }

        reader.close();

        System.out.print(ineffectiveSearch(words, requests));
    }

    /**
     * @param words    словарь
     * @param requests список запросов
     * @return количество действий на каждый запрос с переносом строки после каждого значения
     */
    public static String ineffectiveSearch(String[] words, String[] requests) {
        StringBuilder out = new StringBuilder();

        for (String request : requests) {
            long acts = 0;

            for (String word : words) {
                acts++;

                int commonPrefixLength = 0;
                while (commonPrefixLength < word.length()
                        && commonPrefixLength < request.length()
                        && word.charAt(commonPrefixLength) == request.charAt(commonPrefixLength)) {
                    commonPrefixLength++;
                }
                acts += commonPrefixLength;

                if (word.equals(request)) {
                    break;
                }
            }
            out.append(acts).append("\n");
        }
        return out.toString();
    }
}
