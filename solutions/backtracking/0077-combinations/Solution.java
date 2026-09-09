import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // Base Case
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Recursive Case
        for (int num = start; num <= n; num++) {
            current.add(num);
            backtrack(n, k, num + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}