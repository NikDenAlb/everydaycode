package yandex.coderun.quickstart.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/dictionary-synonyms">task link</a><br>
 * test - OK
 */
public class DictionarySynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        HashMap<String, String> dictionary = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] words = reader.readLine().split(" ");
            dictionary.put(words[0], words[1]);
            dictionary.put(words[1], words[0]);
        }
        String word = reader.readLine();
        String synonym = dictionary.get(word);
        writer.write(synonym);


        reader.close();
        writer.close();
    }
}
