package leetcode.random.task12;

public class FastSolution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        process(sb, '*', 'M', '*', num / 1000);
        num = num % 1000;
        process(sb, 'M', 'C', 'D', num / 100);
        num = num % 100;
        process(sb, 'C', 'X', 'L', num / 10);
        num = num % 10;
        process(sb, 'X', 'I', 'V', num);
        return sb.toString();
    }

    void process(StringBuilder sb, char major, char minor, char middle, int val) {
        if (val <= 3) {
            sb.append(String.valueOf(minor).repeat(Math.max(0, val)));
        } else if (val == 4) {
            sb.append(minor);
            sb.append(middle);
        } else if (val == 5) {
            sb.append(middle);
        } else if (val <= 8) {
            sb.append(middle);
            sb.append(String.valueOf(minor).repeat(val - 5));
        } else if (val == 9) {
            sb.append(minor);
            sb.append(major);
        }
    }
}
