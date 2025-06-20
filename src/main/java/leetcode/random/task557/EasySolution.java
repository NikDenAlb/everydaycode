package leetcode.random.task557;

class EasySolution {
    String reverseWords(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0, j = 0; i != s.length(); ) {
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            for (int k = j - 1; k >= i; k--) {
                out.append(s.charAt(k));
            }
            if (j != s.length()) {
                out.append(s.charAt(j++));
            }
            i = j;
        }
        return out.toString();
    }
}
