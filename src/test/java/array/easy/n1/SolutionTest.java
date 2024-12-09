package array.easy.n1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    static Stream<Arguments> provideSolutions() {
        return Stream.of(
                Arguments.of(new EasySolution()),
                Arguments.of(new HashSolution())
        );
    }

    void assertArrayEqualsUnordered(int[] expected, int[] result) {
        Arrays.sort(expected);
        Arrays.sort(result);
        assertArrayEquals(expected, result, "Arrays are not equal (ignoring order)");
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testTwoSum(Solution solution) {
        int[][] testCases = {
                {2, 7, 11, 15, 9},
                {3, 2, 4, 6},
                {-3, 4, 3, 90, 0},
                {1, 2, 3, 4, 8}
        };

        int[][] expectedAnswers = {
                {0, 1},
                {1, 2},
                {0, 2},
                null
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = Arrays.copyOf(testCases[i], testCases[i].length - 1);
            int target = testCases[i][testCases[i].length - 1];
            int[] expected = (expectedAnswers[i] != null) ? expectedAnswers[i] : null;

            if (expected == null) {
                Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.twoSum(nums, target));
                assertEquals("No two sum solution", exception.getMessage());
            } else {
                int[] result = solution.twoSum(nums, target);
                assertArrayEqualsUnordered(expected, result);
            }
        }
    }
}
