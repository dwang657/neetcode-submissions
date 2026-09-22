class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, sol);
        return sol;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> sol) {
        if (i >= nums.length) {
            sol.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, sol);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, sol);
    }
}
