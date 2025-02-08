package yandex.coderun.quickstart.task18;
//TODO think about hashmap and do dir ref
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/search-in-depth">task link</a><br>
 * test - OK
 */
public class SearchInDepthFast {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringNM = reader.readLine().split(" ");
        int n = Integer.parseInt(stringNM[0]);
        int m = Integer.parseInt(stringNM[1]);
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] stringEdge = reader.readLine().split(" ");
            edges[i][0] = Integer.parseInt(stringEdge[0]);
            edges[i][1] = Integer.parseInt(stringEdge[1]);
        }

        int[] results = findConnectedComponent(edges);
        StringBuilder out = new StringBuilder();
        out.append(results.length).append("\n");
        Arrays.stream(results).forEach(x -> out.append(x).append(" "));

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int[] findConnectedComponent(int[][] edges) {
        List<int[]> list = Arrays.stream(edges)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Set<Integer> connectedComponent = new HashSet<>();
        Set<Integer> newConnectedComponent = new HashSet<>();
        newConnectedComponent.add(1);

        do {
            Set<Integer> dConnectedComponent = list.stream()
                    .filter(e -> newConnectedComponent.contains(e[0]) || newConnectedComponent.contains(e[1]))
                    .flatMap(e -> Arrays.stream(new Integer[]{e[0], e[1]}))
                    .filter(e -> !newConnectedComponent.contains(e))
                    .collect(Collectors.toSet());
            list.removeIf(e -> newConnectedComponent.contains(e[0]) || newConnectedComponent.contains(e[1]));
            connectedComponent.addAll(newConnectedComponent);
            newConnectedComponent.clear();
            newConnectedComponent.addAll(dConnectedComponent);
        } while (!newConnectedComponent.isEmpty());
        return connectedComponent.stream().sorted().mapToInt(i -> i).toArray();
    }
}
