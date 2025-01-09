package leetcode.array.easy.n3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private static Stream<Arguments> solutionsProvider() {
        return Stream.of(
                Arguments.of(new DuplicateSolution()),
                Arguments.of(new EasySolution()),
                Arguments.of(new HashSetBeautySolution()),
                Arguments.of(new HashSetSolution())
        );
    }

    private static Stream<Arguments> validMatricesProvider() {
        return Stream.of(
                Arguments.of((Object) new int[][]{
                        {1, 2, 3},
                        {3, 1, 2},
                        {2, 3, 1}
                }),
                Arguments.of((Object) new int[][]{
                        {1, 2},
                        {2, 1}
                })
        );
    }

    private static Stream<Arguments> invalidMatricesProvider() {
        return Stream.of(
                Arguments.of((Object) new int[][]{
                        {1, 1, 1},
                        {1, 2, 3},
                        {1, 2, 3}
                }),
                Arguments.of((Object) new int[][]{
                        {1, 2, 3},
                        {1, 2, 3},
                        {1, 2, 3}
                }),
                Arguments.of((Object) new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("solutionsProvider")
    @DisplayName("Testing valid matrices")
    void testValidMatrix(Solution solution) {
        validMatricesProvider().forEach(args -> {
            int[][] matrix = (int[][]) args.get()[0];
            assertTrue(solution.checkValid(matrix));
        });
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("solutionsProvider")
    @DisplayName("Testing invalid matrices")
    void testInvalidMatrix(Solution solution) {
        invalidMatricesProvider().forEach(args -> {
            int[][] matrix = (int[][]) args.get()[0];
            assertFalse(solution.checkValid(matrix));
        });
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("solutionsProvider")
    @DisplayName("Testing edge cases")
    void testEdgeCases(Solution solution) {
        int[][] singleElementMatrix = {
                {1}
        };
        assertTrue(solution.checkValid(singleElementMatrix));

        int[][] largeMatrix = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                largeMatrix[i][j] = (j + i) % 100 + 1;
            }
        }
        assertTrue(solution.checkValid(largeMatrix));

        largeMatrix[0][0] = 101;
        assertFalse(solution.checkValid(largeMatrix));
    }
}