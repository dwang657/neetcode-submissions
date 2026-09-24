class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = 0
        r = len(heights) - 1
        water = 0
        
        while l < r:
            height = min(heights[l], heights[r])
            water = max(water, height * (r - l))
            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1
        
        return water