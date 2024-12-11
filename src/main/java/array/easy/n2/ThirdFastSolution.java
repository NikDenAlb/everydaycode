package array.easy.n2;

class ThirdFastSolution implements Solution {
    public int mostFrequentEven(int[] nums) {

        int count = 0;
        int ele = -1;

        int[] freq = new int[100001];

        for (int i : nums) {
            if (i % 2 == 0) {
                freq[i]++;
            }

            if (freq[i] > count || (freq[i] == count && i < ele)) {
                count = freq[i];
                ele = i;
            }
        }

        return ele;
    }
}
