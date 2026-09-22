class Solution {
    public int rob(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
