package leetcode.random.task289;

class Solution {
    void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int bX = Math.max(i - 1, 0); bX <= Math.min(i + 1, board.length - 1); bX++) {
                    for (int bY = Math.max(j - 1, 0); bY <= Math.min(j + 1, board[0].length - 1); bY++) {
                        if (bX != i || bY != j) {
                            cnt += board[bX][bY] & 1;
                        }
                    }
                }
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}