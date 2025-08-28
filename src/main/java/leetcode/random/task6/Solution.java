package leetcode.random.task6;

class Solution {
    String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * numRows - 2) {
            out.append(s.charAt(i));
        }
        for (int r = 1; r < numRows - 1; r++) {
            for (int i = r; i < s.length(); ) {
                out.append(s.charAt(i));
                i += 2 * numRows - 2;
                int j = i - 2 * r;
                if (j < s.length()) {
                    out.append(s.charAt(j));
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += 2 * numRows - 2) {
            out.append(s.charAt(i));
        }
        return out.toString();
    }
}

/*
   0        ..                         2nR-2
   1        ..                 2nR-3   2nR-1
   2        ..         2nR-4           2nR
   3        ..  2nR-5 <<-----2r----->> 2nR+1
  ..        ..                         ..
nR-2   nR   ..                         3nR-2
nR-1        ..                         3nR-3


0      6       12
1   5  7    11 13
2 4    8 10    14
3      9       15
*/