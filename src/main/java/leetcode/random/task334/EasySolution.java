package leetcode.random.task334;

class EasySolution {
    boolean increasingTriplet(int[] nums) {
        int mOne = Integer.MAX_VALUE;
        int mTwo = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mTwo) {
                return true;
            }
            if (num > mOne) {
                mTwo = num;
            }
            if (num < mOne) {
                mOne = num;
            }
        }
        return false;
    }
}
