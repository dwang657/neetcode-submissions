class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxL = heights[left];
        int maxR = heights[right];
        int max = Math.min(maxL, maxR) * (right - left);

        while (left < right) {
            if (maxL < maxR) {
                left++;
                maxL = Math.max(maxL, heights[left]);
            } else {
                right--;
                maxR = Math.max(maxR, heights[right]);
            }
            max = Math.max(max, Math.min(maxL, maxR) * (right - left));
        }

        return max;
    }
}
