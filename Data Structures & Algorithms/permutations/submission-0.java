class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums, sub, sol);
        return sol;
    }

    private void helper(int[] nums, List<Integer> sub, List<List<Integer>> sol) {
        if (sub.size() == nums.length) {
            sol.add(new ArrayList<>(sub));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (sub.contains(nums[i])) {
                    continue;
                }
                sub.add(nums[i]);
                helper(nums, sub, sol);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
