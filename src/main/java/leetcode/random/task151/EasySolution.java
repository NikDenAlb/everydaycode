package leetcode.random.task151;

public class EasySolution {
    String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder out = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            out.append(split[i]).append(' ');
        }
        out.append(split[0]);
        return out.toString();
    }
}
