import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Construct the graph. Let the vertices be courses, and an edge from a -> b
        // indicates that a is a prerequisite for b.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            if (!graph.containsKey(prereq)) {
                graph.put(prereq, new ArrayList<>());
            }
            graph.get(prereq).add(course);
        }

        // Add courses that are not prerequisites of any other courses to the graph
        for (int course = 0; course < numCourses; course++) {
            graph.putIfAbsent(course, new ArrayList<>());
        }

        // Result list which will either be empty or have a valid topological sort.
        List<Integer> order = new ArrayList<>();

        // State array: 0 = unvisisted, 1 = visiting, 2 = done
        int[] state = new int[numCourses];

        // Run DFS from every course node and construct a valid topological sort if there is one
        // (no cycle in the graph), otherwise return an empty array. 
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (hasCycle(graph, course, state, order)) {
                    return new int[0];
                }
            }
        }

        // We need to reverse the result list since it appends "done" nodes first (all dependencies processed)
        // but we want the order to be dependencies first. Then we convert the List<Integer> to an int[].
        Collections.reverse(order);
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, int[] state, List<Integer> order) {
        // Mark the current course as "visiting"
        state[course] = 1;
        for (int neighbor : graph.get(course)) {
            // If a neighbor is still "visiting" then we have a cycle
            if (state[neighbor] == 1) {
                return true;
            } else if (state[neighbor] == 0) {
                if (hasCycle(graph, neighbor, state, order)) {
                    return true;
                }
            } else {
                continue;  // state[neighbor] == 2
            }
        }
        // Mark the current course as "done" (all dependencies processed) and append it to order
        state[course] = 2;
        order.add(course);
        return false;  // no cycle detected
    }
}