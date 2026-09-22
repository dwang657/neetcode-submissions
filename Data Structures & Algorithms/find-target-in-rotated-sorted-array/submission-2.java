class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int target, int start, int end) {
        if (start >= end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] <= nums[mid]) {
            if (nums[mid] < target || nums[start] > target) {
                return helper(nums, target, mid + 1, end);
            } else {
                return helper(nums, target, start, mid - 1);
            }
        } else {
            if (target < nums[mid] || target > nums[end]) {
                return helper(nums, target, start, mid - 1);
            } else {
                return helper(nums, target, mid + 1, end);
            }
        }
    }
}
