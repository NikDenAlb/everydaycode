package yandex.coderun.random.task16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/cheating">task link</a><br>
 * test - TL
 */
public class Metro2TL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        Map<Integer, Set<Integer>> lines = new HashMap<>();
        Set<Integer> unVisited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            unVisited.add(i);
            lines.put(i, Arrays.stream(reader.readLine().split(" ")).skip(1).map(Integer::parseInt).collect(Collectors.toSet()));
        }
        String[] startEnd = reader.readLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        Set<Integer> goal = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (lines.get(i).contains(end)) {
                goal.add(i);
            }
        }

        Set<Integer> step = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (lines.get(i).contains(start)) {
                if (goal.contains(i)) {
                    writer.write("0");
                    reader.close();
                    writer.close();
                    return;
                }
                unVisited.remove(i);
                step.add(i);
            }
        }

        /*
        unVisited - lines still not visited
        step - list of new current lines
        count - current step to out

        lines - database line-stations

         */
        int count = 1;
        while (!unVisited.isEmpty() || !step.isEmpty()) {
            Set<Integer> newStep = new HashSet<>();

            //Взяли все станции этого шага для поиска пересечений с каждой линией
            Set<Integer> currentStations = new HashSet<>();
            step.forEach(i -> currentStations.addAll(lines.get(i)));

            for (Integer lineNum : unVisited) {
                Set<Integer> line = new HashSet<>(lines.get(lineNum));
                line.retainAll(currentStations);
                if (!line.isEmpty()) {
                    if (goal.contains(lineNum)) {
                        writer.write(Integer.toString(count));
                        reader.close();
                        writer.close();
                        return;
                    }
                    newStep.add(lineNum);
                }
            }
            unVisited.removeAll(newStep);
            step = newStep;
            count++;
        }

        writer.write("-1");

        reader.close();
        writer.close();
    }

}
