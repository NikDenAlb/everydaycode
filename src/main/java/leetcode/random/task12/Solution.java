package leetcode.random.task12;

class Solution {
    String[] M = new String[]{"", "M", "MM", "MMM"};
    String[] C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] X = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    String intToRoman(int num) {
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }
}
