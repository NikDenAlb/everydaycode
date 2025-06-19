package leetcode.random.task205;

/**
 * My modification on speedy solution
 */
class ArraySolution {
    boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ch1 = new int[128];
        int[] ch2 = new int[128];
        for (int i = 0; i < s.length(); ) {
            if (ch1[s.charAt(i)] != ch2[t.charAt(i)]) {
                return false;
            }
            ch1[s.charAt(i)] = i + 1;
            ch2[t.charAt(i)] = ++i;
        }
        return true;
    }
}
