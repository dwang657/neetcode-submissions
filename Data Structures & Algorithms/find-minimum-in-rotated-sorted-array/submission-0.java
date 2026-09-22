class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[start];
        }

        int mid = (start + end) / 2;

        if (nums[mid] < nums[end]) {
            return helper(nums, start, mid);
        } else {
            return helper(nums, mid + 1, end);
        }
    }
}
