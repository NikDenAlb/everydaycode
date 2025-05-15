package leetcode.random.task13;

class EasySolution {
    int romanToInt(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> throw new Error("invalid input");
            };
            if (3 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}
