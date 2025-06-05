package leetcode.random.task2390;

/**
 * 17ms vs 30ms of Easy
 */
class ReverseOrderSolution {
    String removeStars(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') count++;
            else {
                if (count == 0) ans.append(s.charAt(i));
                else count--;
            }
        }
        ans.reverse();
        return ans.toString();
    }
}
