package leetcode.random.task125;

class EasySolution {
    boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
