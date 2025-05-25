package leetcode.random.task443;

class EasySolution {
    int compress(char[] chars) {
        int a = 0;
        for (int i = 0; i < chars.length; ) {
            char chr = chars[i++];
            int count = 1;
            while (i < chars.length && chars[i] == chr) {
                count++;
                i++;
            }
            chars[a++] = chr;
            if (count > 1) {
                for (char ch : Integer.toString(count).toCharArray()) {
                    chars[a++] = ch;
                }
            }
        }
        return a;
    }
}
