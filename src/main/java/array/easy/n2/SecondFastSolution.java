package array.easy.n2;

/**
 * 2nd time solution from LeetCode
 * it's int[] solution like crazy, but looks prettier
 */
class SecondFastSolution implements Solution {
    public int mostFrequentEven(int[] nums) {
        int max = 0;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        int[] count = new int[max + 1];
        int maxi = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                count[num]++;
                maxi = Math.max(maxi, count[num]);
            }
        }
        int a = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxi) {
                a = i;
                break;

            }
        }
        return a;
    }
}
