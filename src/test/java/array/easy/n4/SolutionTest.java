package array.easy.n4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private static Stream<Arguments> solutionsProvider() {
        return Stream.of(
                Arguments.of(new EasySolution(), "EasySolution")
        );
    }


    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6),
                Arguments.of(new int[]{0, 0, 0, 1}, 0),
                Arguments.of(new int[]{1, 100, 1, 100, 1}, 3),
                Arguments.of(new int[]{10, 15}, 10),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 6),
                Arguments.of(new int[]{1, 100, 1, 100, 1, 100, 1, 100, 1, 100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30) // large input
        );
    }

    // объединенный провайдер
    private static Stream<Arguments> combinedProvider() {
        return solutionsProvider().flatMap(solutionArg ->
                provideData().map(dataArg -> {
                    Solution solution = (Solution) solutionArg.get()[0];
                    String solutionName = (String) solutionArg.get()[1];
                    int[] cost = (int[]) dataArg.get()[0];
                    int expected = (int) dataArg.get()[1];
                    return Arguments.of(solution, solutionName, cost, expected);
                }));
    }

    @ParameterizedTest
    @MethodSource("combinedProvider")
    void testMinCostClimbingStairs(Solution solution, String solutionName, int[] cost, int expected) {
        Instant start = Instant.now();
        int actual = solution.minCostClimbingStairs(cost);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        assertEquals(expected, actual);
        System.out.printf("%s took %d ns for input size %d%n", solutionName, duration.toNanos(), cost.length);
    }
}
