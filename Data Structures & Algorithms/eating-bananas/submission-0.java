class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];
        for (int i = 1; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) {
                    hours++;
                }
            }
            if (hours <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

// binary search for rate 