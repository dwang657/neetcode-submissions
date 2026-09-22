class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, sub, sol);
        return sol;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> sub, List<List<Integer>> sol) {
        if (target == 0) {
            sol.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            sub.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], sub, sol);
            sub.remove(sub.size() - 1);
        }
    }
}
