class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums, 0, target, sub, sol);
        return sol;
    }

    private void helper(int[] nums, int i, int target, List<Integer> sub, List<List<Integer>> sol) {
        if (i >= nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            sol.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        helper(nums, i, target - nums[i], sub, sol);
        sub.remove(sub.size() - 1);
        helper(nums, i + 1, target, sub, sol);
    }
}
