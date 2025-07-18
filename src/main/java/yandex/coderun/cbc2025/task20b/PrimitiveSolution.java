package yandex.coderun.cbc2025.task20b;

public class PrimitiveSolution {
    long calculateAnswer(int n, int k, int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (gcd(a[i], a[j]) == k) {
                    sum++;
                }
            }
        }
        return sum;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
