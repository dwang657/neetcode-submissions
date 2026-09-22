class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, sub, sol);
        return sol;
    }

    private void dfs(int[] nums, int i, List<Integer> sub, List<List<Integer>> sol) {
        if (i >= nums.length) {
            sol.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(nums, i + 1, sub, sol);
        sub.remove(sub.size() - 1);
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }
        dfs(nums, i + 1, sub, sol);
    }
}
