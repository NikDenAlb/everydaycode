package array.easy.n2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    static Stream<Arguments> provideSolutions() {
        return Stream.of(
                Arguments.of(new EasySolution()),
                Arguments.of(new CrazySolution())
        );
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testMostFrequentEven_ValidInput(Solution solution) {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 6};
        int expected = 4;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testMostFrequentEven_MultipleMostFrequent(Solution solution) {
        int[] nums = {2, 2, 4, 4, 6, 6};
        int expected = 2;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testMostFrequentEven_NoEven(Solution solution) {
        int[] nums = {1, 3, 5, 7, 9};
        int expected = -1;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testMostFrequentEven_EmptyArray(Solution solution) {
        int[] nums = {};
        int expected = -1;
        int result = solution.mostFrequentEven(nums);
        assertEquals(expected, result);
    }
}
