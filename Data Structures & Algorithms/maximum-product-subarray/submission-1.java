class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(nums[i], Math.max(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]));
            max = Math.max(max, dp[0][i]);
            dp[1][i] = Math.min(nums[i], Math.min(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]));
        }

        return max;
    }
}