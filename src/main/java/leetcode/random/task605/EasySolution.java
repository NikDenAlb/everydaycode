package leetcode.random.task605;

public class EasySolution {
    boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length - 1) {
            if (flowerbed[i] == 1) {
                do {
                    i++;
                } while (i < flowerbed.length && flowerbed[i] == 1);
                i++;
                continue;
            }
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                count++;
                i += 2;
            } else {
                i += 3;
            }
        }
        if (i == flowerbed.length - 1 && flowerbed[i] == 0) {
            count++;
        }
        return count >= n;
    }
}
