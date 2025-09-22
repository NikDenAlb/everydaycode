package leetcode.random.task36;

import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!isValidNine(row)) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch != '.' && !set.add(ch)) {
                    return false;
                }
            }
        }

        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.' && !boxes[i / 3 * 3 + j / 3].add(ch)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValidNine(char[] nine) {
        Set<Character> set = new HashSet<>();
        for (char ch : nine) {
            if (ch != '.' && !set.add(ch)) {
                return false;
            }
        }
        return true;
    }
}