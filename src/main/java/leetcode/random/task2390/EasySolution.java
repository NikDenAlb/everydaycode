package leetcode.random.task2390;

class EasySolution {
    String removeStars(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                out.setLength(out.length() - 1);
                continue;
            }
            out.append(s.charAt(i));
        }
        return out.toString();
    }
}
