package leetcode.random.task67;

class EasySolution {
    String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int i = 0;
        boolean add = false;
        StringBuilder sb = new StringBuilder();
        for (; i < a.length(); i++) {
            if (add) {
                if (a.charAt(a.length() - 1 - i) == '1') {
                    if (b.charAt(b.length() - 1 - i) == '1') {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                } else {
                    if (b.charAt(b.length() - 1 - i) == '1') {
                        sb.append('0');
                    } else {
                        sb.append('1');
                        add = false;
                    }
                }
            } else {
                if (a.charAt(a.length() - 1 - i) == '1') {
                    if (b.charAt(b.length() - 1 - i) == '1') {
                        sb.append('0');
                        add = true;
                    } else {
                        sb.append('1');
                    }
                } else {
                    if (b.charAt(b.length() - 1 - i) == '1') {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
            }
        }
        for (; add && i < b.length(); i++) {
            if (b.charAt(b.length() - 1 - i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
                add = false;
            }
        }
        if (add) {
            sb.append('1');
            return sb.reverse().toString();
        }
        return b.substring(0, b.length() - i) + sb.reverse();
    }
}
