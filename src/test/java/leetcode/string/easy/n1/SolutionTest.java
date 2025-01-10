package leetcode.string.easy.n1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> solutionsProvider() {
        return Stream.of(
                Arguments.of(new EasySolution()),
                Arguments.of(new TwoPointerSolution())
        );
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("abbxxxxzzy", List.of(List.of(3, 6))),
                Arguments.of("abc", List.of()),
                Arguments.of("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14))),
                Arguments.of("aaaabbbccddeeeff", List.of(List.of(0, 3), List.of(4, 6), List.of(11, 13))),
                Arguments.of("abcde", List.of()),
                Arguments.of("aaabccc", List.of(List.of(0, 2), List.of(4, 6)))
        );
    }

    private static Stream<Arguments> combinedProvider() {
        return solutionsProvider().flatMap(solutionArg ->
                provideData().map(dataArg -> {
                    Solution solution = (Solution) solutionArg.get()[0];
                    String s = (String) dataArg.get()[0];
                    List<List<Integer>> expected = (List<List<Integer>>) dataArg.get()[1];
                    return Arguments.of(solution, s, expected);
                }));
    }

    @ParameterizedTest
    @MethodSource("combinedProvider")
    void testLargeGroupPositions(Solution solution, String s, List<List<Integer>> expected) {
        List<List<Integer>> actual = solution.largeGroupPositions(s);
        assertEquals(expected, actual);
    }
}
