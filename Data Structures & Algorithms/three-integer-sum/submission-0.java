class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                int total = nums[a] + nums[b] + nums[c];
                if (total > 0) {
                    c--;
                } else if (total < 0) {
                    b++;
                } else {
                    sol.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    b++;
                    while (nums[b] == nums[b - 1] && b < c) {
                        b++;
                    }
                }
            }
        }
        return sol;
    }
}
