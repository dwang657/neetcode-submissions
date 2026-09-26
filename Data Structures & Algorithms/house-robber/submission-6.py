class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        n = len(nums)
        dp = [0] * (n + 1)
        for i in range(n):
            if i == 0:
                dp[0] = nums[0]
            if i == 1:
                dp[1] = max(nums[0], nums[1])
            else:
                dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[n - 1]