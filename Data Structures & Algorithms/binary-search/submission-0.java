class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int start, int end, int target) {
        if (start >= end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return helper(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return helper(nums, start, mid - 1, target);
        } else {
            return mid;
        }
    }
}
