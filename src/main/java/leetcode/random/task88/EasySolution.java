package leetcode.random.task88;

class EasySolution {
    void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy1 = new int[m];
        System.arraycopy(nums1, 0, copy1, 0, m);
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            if (copy1[j] < nums2[k]) {
                nums1[i++] = copy1[j++];
            } else {
                nums1[i++] = nums2[k++];
            }
        }
        if (j == m) {
            System.arraycopy(nums2, k, nums1, i, n-k);
        } else {
            System.arraycopy(copy1, j, nums1, i, m-j);
        }
    }
}
