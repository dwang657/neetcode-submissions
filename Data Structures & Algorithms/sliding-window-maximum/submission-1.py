class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        sol = []
        q = deque() # deque of indices
        l = 0
        r = 0

        while r < len(nums):
            # pop all indices in q that correspond to elements in nums < nums[r]
            # this makes sure deque is sorted in decreasing order
            while q and nums[q[-1]] < nums[r]: 
                q.pop()
            q.append(r)

            # if the window has shifted past q[0]
            if l > q[0]:
                q.popleft()
            
            # once our window is of size k, q[0] will hold max of window
            if r >= k - 1:
                sol.append(nums[q[0]])
                l += 1
            
            r += 1
        
        return sol