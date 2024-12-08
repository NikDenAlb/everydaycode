package array.easy.n1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testTwoSum_ValidInput() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1}; // Индексы элементов, которые дают сумму 9 (2 + 7)

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    void testTwoSum_AnotherValidInput() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2}; // Индексы элементов, которые дают сумму 6 (2 + 4)

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    void testTwoSum_NegativeNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expected = {0, 2}; // Индексы элементов, которые дают сумму 0 (-3 + 3)

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    void testTwoSum_NoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 8;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.twoSum(nums, target));

        assertEquals("No two sum solution", exception.getMessage());
    }

    // Метод, который предоставляет входные данные для параметризованных тестов
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2}),
                Arguments.of(new int[]{1, 2, 3, 4}, 8, null) // Случай без решения
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testTwoSum(int[] nums, int target, int[] expected) {
        if (expected == null) {
            // Ожидание исключения при отсутствии решения
            Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.twoSum(nums, target));
            assertEquals("No two sum solution", exception.getMessage());
        } else {
            // Выполнение основной логики теста
            int[] result = solution.twoSum(nums, target);
            assertArrayEquals(expected, result);
        }
    }
}
