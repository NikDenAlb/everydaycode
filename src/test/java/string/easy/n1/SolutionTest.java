package string.easy.n1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> solutionsProvider() {
        return Stream.of(
                Arguments.of(new EasySolution(), "EasySolution")
        );
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("abbxxxxzzy", List.of(Arrays.asList(3, 6))),
                Arguments.of("abc", List.of()),
                Arguments.of("abcdddeeeeaabbbcd", Arrays.asList(Arrays.asList(3, 5), Arrays.asList(6, 9), Arrays.asList(12, 14))),
                Arguments.of("aaaabbbccddeeeff", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(4, 6), Arrays.asList(11, 13))),
                Arguments.of("abcde", List.of()),
                Arguments.of("aaabccc", List.of(Arrays.asList(0, 2), Arrays.asList(4, 6)))
        );
    }

    private static Stream<Arguments> combinedProvider() {
        return solutionsProvider().flatMap(solutionArg ->
                provideData().map(dataArg -> {
                    Solution solution = (Solution) solutionArg.get()[0];
                    String solutionName = (String) solutionArg.get()[1];
                    String s = (String) dataArg.get()[0];
                    List<List<Integer>> expected = (List<List<Integer>>) dataArg.get()[1];
                    return Arguments.of(solution, solutionName, s, expected);
                }));
    }

    @ParameterizedTest
    @MethodSource("combinedProvider")
    void testLargeGroupPositions(String s, List<List<Integer>> expected) {
        Solution solution = new EasySolution();
        List<List<Integer>> actual = solution.largeGroupPositions(s);
        assertEquals(expected, actual);
    }
}
