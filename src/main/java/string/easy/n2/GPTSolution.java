package string.easy.n2;

import java.util.HashMap;
import java.util.Map;

public class GPTSolution implements Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (!charToWordMap.containsKey(currentChar)) {
                charToWordMap.put(currentChar, currentWord);
            } else {
                if (!charToWordMap.get(currentChar).equals(currentWord)) {
                    return false;
                }
            }

            // Проверяем соответствие текущего слова символу
            if (!wordToCharMap.containsKey(currentWord)) {
                wordToCharMap.put(currentWord, currentChar);
            } else {
                // Если соответствие найдено - проверяем его правильность
                if (!wordToCharMap.get(currentWord).equals(currentChar)) {
                    return false;
                }
            }
        }

        return true; // Если все проверки пройдены, значит, соответствует
    }
}
