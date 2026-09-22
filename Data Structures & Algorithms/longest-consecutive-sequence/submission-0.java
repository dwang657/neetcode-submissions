class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int count = 1;
            int n = num;
            while (set.contains(n - 1)) {
                count++;
                max = Math.max(max, count);
                n = n - 1;
            }
            n = num;
            while (set.contains(n + 1)) {
                count++;
                max = Math.max(max, count);
                n = n + 1;
            }
            set.add(num);
        }
        return max;
    }
}
