package array.easy.n2;

/**
 * Best time solution from LeetCode
 */
public class CrazySolution implements Solution{
    public int mostFrequentEven(int[] nums) {
        int[] cnt = new int[50001];
        int maxFreq = 0;
        int maxElem = -1;
        for(int num : nums) {
            if(num % 2 == 1) continue;
            int freq = ++cnt[num >> 1];
            if(freq > maxFreq || (freq == maxFreq && num < maxElem)) {
                maxFreq = freq;
                maxElem = num;
            }
        }
        return maxElem;
    }
}
