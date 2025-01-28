package yandex.coderun.hrtechinterview.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/shortest-path-length">task link</a><br>
 * test - OK
 */
public class ShortestPathLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] adjM = new int[n][n];
        for (int i = 0; i < adjM.length; i++) {
            adjM[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        String[] numsStartEnd = reader.readLine().split(" ");
        int start = Integer.parseInt(numsStartEnd[0]);
        int end = Integer.parseInt(numsStartEnd[1]);

        writer.write(String.valueOf(findShortestPathLength(start - 1, end - 1, adjM)));

        reader.close();
        writer.close();
    }

    static int findShortestPathLength(int start, int end, int[][] adjM) {
        if (start == end) {
            return 0;
        }
        int length = 0;
        Set<Integer> unVisited = IntStream.range(0, adjM.length).boxed().collect(Collectors.toSet());
        unVisited.remove(start);
        Set<Integer> newVisit = new HashSet<>(List.of(start));
        while (!newVisit.isEmpty()) {
            length++;
            Set<Integer> currVisit = new HashSet<>();
            newVisit.forEach(v ->
                    unVisited.forEach(r ->
                            {
                                if (adjM[v][r] == 1) {
                                    currVisit.add(r);
                                }
                            }
                    ));
            if (currVisit.contains(end))
                return length;
            newVisit = currVisit;
            unVisited.removeAll(newVisit);
        }
        return -1;
    }
}
