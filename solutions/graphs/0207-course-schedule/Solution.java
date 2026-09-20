import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct the graph. Let the vertices be courses and edge from a -> b represent
        // that a is a prerequisite of b.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            // Add edge from prereq -> course
            if (!graph.containsKey(prereq)) {
                graph.put(prereq, new ArrayList<>());
            }
            graph.get(prereq).add(course);
        }

        // Add courses that are not prerequisites to any other course to the graph (empty list)
        for (int course = 0; course < numCourses; course++) {
            graph.putIfAbsent(course, new ArrayList<>());
        }

        // State array: 0 = unvisited, 1 = visiting, 2 = done
        int[] state = new int[numCourses];

        // Run DFS from every course to check if it can be taken
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (hasCycle(graph, course, state)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns true if a cycle is detected in the given graph with the current course and state.
    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, int[] state) {
        // Mark the current course as "visiting"
        state[course] = 1;
        for (int neighbor : graph.get(course)) {
            // If a neighbor is still "visiting" then we have a cycle
            if (state[neighbor] == 1) {
                return true;
            } else if (state[neighbor] == 0) {
                if (hasCycle(graph, neighbor, state)) {
                    return true;
                }
            } else {
                continue; // state[neighbor == 2], this course confirmed possible
            }
        }
        state[course] = 2;  // mark this course as safe (confirmed possible)
        return false;  // no cycle detected from this node
    }
}