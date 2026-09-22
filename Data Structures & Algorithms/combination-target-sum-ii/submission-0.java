class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, sub, sol);
        return sol;
    }

    private void helper(int[] candidates, int i, int target, List<Integer> sub, List<List<Integer>> sol) {
        if (target == 0) {
            sol.add(new ArrayList<>(sub));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        sub.add(candidates[i]);
        helper(candidates, i + 1, target - candidates[i], sub, sol);
        sub.remove(sub.size() - 1);
        while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
            i++;
        }
        helper(candidates, i + 1, target, sub, sol);
    }
}
