package leetcode.random.task399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            result[i] = findPath(x, y, graph);
        }

        return result;
    }

    double findPath(String start, String end, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        Queue<NodeValue> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new NodeValue(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            NodeValue current = queue.poll();
            String node = current.node;
            double value = current.value;

            if (node.equals(end)) {
                return value;
            }

            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
                String neighbor = entry.getKey();
                double weight = entry.getValue();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new NodeValue(neighbor, value * weight));
                }
            }
        }

        return -1.0;
    }

    record NodeValue(String node, double value) {
    }
}
