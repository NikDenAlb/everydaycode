package string.easy.n2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> solutionsProvider() {
        return Stream.of(
                Arguments.of(new EasySolution()),
                Arguments.of(new GPTSolution()),
                Arguments.of(new BestSolution())
        );
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("aaaa", "dog cat cat dog", false),
                Arguments.of("a", "dog", true),
                Arguments.of("a", "dog dog", false),
                Arguments.of("abc", "foo bar baz", true),
                Arguments.of("abcd", "apple banana cherry date", true),
                Arguments.of("abab", "apple banana apple banana", true),
                Arguments.of("aaaa", "apple apple apple apple", true),
                Arguments.of("abba", "dog dog dog dog", false),
                Arguments.of("abc", "", false),
                Arguments.of("", "foo", false),
                Arguments.of("a", " ", false)
        );
    }

    private static Stream<Arguments> combinedProvider() {
        return solutionsProvider().flatMap(solutionArg ->
                testCases().map(testCaseArg -> {
                    Solution solution = (Solution) solutionArg.get()[0];
                    String pattern = (String) testCaseArg.get()[0];
                    String s = (String) testCaseArg.get()[1];
                    boolean expected = (Boolean) testCaseArg.get()[2];
                    return Arguments.of(solution, pattern, s, expected);
                }));
    }

    @ParameterizedTest
    @MethodSource("combinedProvider")
    void testWordPattern(Solution solution, String pattern, String s, boolean expected) {
        boolean actual = solution.wordPattern(pattern, s);
        assertEquals(expected, actual);
    }
}
