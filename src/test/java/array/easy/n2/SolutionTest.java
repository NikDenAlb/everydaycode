package array.easy.n2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new EasySolution();

    @Test
    void testMostFrequentEven_ValidInput() {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 6};
        int expected = 4;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @Test
    void testMostFrequentEven_MultipleMostFrequent() {
        int[] nums = {2, 2, 4, 4, 6, 6};
        int expected = 2;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @Test
    void testMostFrequentEven_NoEven() {
        int[] nums = {1, 3, 5, 7, 9};
        int expected = -1;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @Test
    void testMostFrequentEven_EmptyArray() {
        int[] nums = {};
        int expected = -1;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @Test
    void testMostFrequentEven_NegativeNumbers() {
        int[] nums = {-2, -2, -4, 0, 0, 2, 2};
        int expected = -2;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }
}