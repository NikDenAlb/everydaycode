package yandex.coderun.cbc2025.task3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @Test
    public void testCase1() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 5;
        int m = 3;
        int[] swaps = {1, 6, 2, 4, 5, 3};
        int[] expectedResult = solutionPrimitive.solve(n, m, swaps);
        System.out.println(Arrays.toString(solutionPrimitive.solve(n, m, swaps)));
        System.out.println(Arrays.toString(solution.solve(n, m, swaps)));

        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase2() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 3;
        int m = 2;
        int swaps[] = {1, 4, 2, 3};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase3() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 4;
        int m = 1;
        int swaps[] = {2, 7};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase4() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 6;
        int m = 4;
        int swaps[] = {1, 7, 3, 5, 2, 8, 4, 6};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase5() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 2;
        int m = 1;
        int swaps[] = {1, 3};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase6() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 7;
        int m = 5;
        int swaps[] = {1, 8, 2, 9, 3, 10, 4, 11, 5, 12};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    // Дополнительные тесты

    @Test
    public void testCase7() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 10;
        int m = 5;
        int swaps[] = {1, 11, 2, 12, 3, 13, 4, 14, 5, 15};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase8() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 8;
        int m = 3;
        int swaps[] = {1, 9, 4, 7, 8, 16};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }

    @Test
    public void testCase9() {
        Solution solution = new Solution();
        SolutionPrimitive solutionPrimitive = new SolutionPrimitive();
        int n = 9;
        int m = 6;
        int swaps[] = {1, 10, 2, 11, 3, 12, 4, 13, 5, 14, 6, 15};
        int expectedResult[] = solutionPrimitive.solve(n, m, swaps);
        assertArrayEquals(expectedResult, solution.solve(n, m, swaps));
    }
}
