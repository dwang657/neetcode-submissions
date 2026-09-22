class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                sol[0] = map.get(target - nums[i]);
                sol[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return sol;
    }
}
