package leetcode.random.task58;

public class EasySolution {
    int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return end - i;
    }
}
