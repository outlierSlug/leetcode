import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    // Record representing the target and edge weight of an edge from a  source node.
    record Edge(String node, double weight) {}
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // This problem can be represented by a graph, where variables are vertices
        // and an edge from a -> b with weight w represents the equation a/b = w.
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double w = values[i];

            // Add the variables and weights to the graph
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(new Edge(b, w));
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(b).add(new Edge(a, 1 / w));  // a/b = w -> b/a = 1/w
        }

        // Evaluate queries and place them in result. Run DFS starting from the start variable
        // and multiply weights along its path until either end is reached or an invalid case is hit.
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            // If either variable is not part of the original equations, answer for this query is undefined.
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            result[i] = dfs(graph, start, end, 1.0, visited);
        }
        return result;
    }

    private double dfs(Map<String, List<Edge>> graph, String current, String target, double product, Set<String> visited) {
        // Base case: target variable found, return the accumulated product.
        if (current.equals(target)) {
            return product;
        }
        // Add the current node to the visited set.
        visited.add(current);

        // For every neighbor of the current node that is not visited yet, recursively accumulate the product
        // in search for the target node. If the target node is found, a valid result will be returned.
        for (Edge neighbor : graph.get(current)) {
            if (!visited.contains(neighbor.node())) {
                double result = dfs(graph, neighbor.node(), target, product * neighbor.weight(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        // If all neighbors are exhausted and target is not found, the two variables are not related through
        // a valid system of equations and the answer for this query is undefined.
        return -1.0;
    }
}