package leetcode.random.task557;

/**
 * Fastest solution
 */
public class SwapSolution {
    public static void SwapWord(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        char str[] = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                continue;
            }
            int j = i;
            while (j < str.length && str[j] != ' ') {
                j++;
            }
            SwapWord(str, i, j - 1);
            i = j;
        }
        return new String(str);
    }
}
