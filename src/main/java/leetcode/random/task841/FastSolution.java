package leetcode.random.task841;

import java.util.List;

/**
 * Let's knock from new keys
 */
class FastSolution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(visited, rooms, 0);
        for (boolean i : visited) {
            if (!i) return false;
        }
        return true;
    }

    private void visit(boolean[] visited, List<List<Integer>> rooms, int curr) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (Integer room : rooms.get(curr)) {
            visit(visited, rooms, room);
        }
    }
}
