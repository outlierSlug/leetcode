import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void backtrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(index + 1, current, nums, result);
        current.remove(current.size() - 1);
        backtrack(index + 1, current, nums, result);
    }
}