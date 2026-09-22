class Solution {
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];

        while (left < right) {
            if (maxL < maxR) {
                left++;
                maxL = Math.max(maxL, height[left]);
                water += maxL - height[left];
            } else {
                right--;
                maxR = Math.max(maxR, height[right]);
                water += maxR - height[right];
            }
        }

        return water;
    }
}
