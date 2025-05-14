package leetcode.random.task1768;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately">task link</a><br>
 */
class EasySolution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        if (word1.length() < word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word2.substring(word1.length()));
        } else if (word2.length() < word1.length()) {
            for (int i = 0; i < word2.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(word2.length()));
        } else {
            for (int i = 0; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
