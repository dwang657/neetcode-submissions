class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            q.addLast(right);

            if (left > q.getFirst()) {
                q.removeFirst();
            }

            if (right + 1 >= k) {
                output[left] = nums[q.getFirst()];
                left++;
            }
        }

        return output;
    }
}