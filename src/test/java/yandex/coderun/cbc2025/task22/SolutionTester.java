package yandex.coderun.cbc2025.task22;

import java.util.Random;

public class SolutionTester {
    private static int testCount = 0; // Test counter

    // Метод генерации массива с правильным типом возвращаемого значения
    private static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length]; // Исправлен тип

        for (int i = 0; i < length; i++) {
            int value;
            do {
                // 10% шанс получить -1
                if (random.nextDouble() < 0.1) {
                    value = -1;
                } else {
                    // Генерируем число от 1 до length
                    value = random.nextInt(length) + 1;
                }
            } while (value == i + 1); // Проверяем условие ai != i+1

            array[i] = value;
        }
        return array;
    }

    public static void main(String[] args) {
        PrimitiveSolution correctSolution = new PrimitiveSolution();
        Solution testSolution = new Solution();
        Random random = new Random();

        while (true) {
            // Генерируем длину массива
            int n = random.nextInt(20) + 1;

            // Создаем тестовый массив
            int[] a = generateRandomArray(n); // Исправлен тип

            // Получаем результаты
            int[] correctResult = correctSolution.calculateAnswer(n, a);
            int[] testResult = testSolution.calculateAnswer(n, a);

            // Проверяем результаты
            if (!arraysEqual(correctResult, testResult)) {
                System.out.println("Mismatch found in test case!");
                System.out.println("Input data:");
                printArray(a);
                System.out.println("Expected result:");
                printArray(correctResult);
                System.out.println("Actual result:");
                printArray(testResult);
                break;
            }

            // Увеличиваем счетчик тестов
            testCount++;

            // Выводим статус каждые 100 тестов
            if (testCount % 100 == 0) {
                System.out.println("Passed " + testCount + " tests");
            }
        }
    }

    // Метод сравнения массивов
    private static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // Метод форматированного вывода массива
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
