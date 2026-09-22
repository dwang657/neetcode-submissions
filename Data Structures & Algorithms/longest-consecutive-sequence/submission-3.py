class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        seen = set()
        for num in nums:
            seen.add(num)
        
        longest = 1
        
        for num in seen:
            if num - 1 not in seen:
                length = 1
                while num + 1 in seen:
                    length += 1
                    num += 1
                longest = max(longest, length)
        
        return longest
            