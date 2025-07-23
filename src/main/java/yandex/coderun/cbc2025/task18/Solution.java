package yandex.coderun.cbc2025.task18;


public class Solution {
    public long solve(int n, int m) {
        long cnt = 0;
        long c = 1;
        long add = n + 1;
        long line = 0;

        long i = 1;
        while (add > 0) {
            for (; i <= c; i++) {
                cnt += add;
                if (cnt >= m) {
                    return i;
                }
            }
            c = c * (n - line) / (line + 1);
            line++;
            add -= 2;
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(1, 2));
        //1
        System.out.println(solution.solve(5, 6));
        //1
        System.out.println(solution.solve(3, 5));
        //2

    }
}


/*


[0][1][2][3][4][5][6][7]...[n]



 */