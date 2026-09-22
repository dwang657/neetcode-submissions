class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {}
        elements = [[] for i in range(len(nums) + 1)]
        for num in nums:
            freqs[num] = 1 + freqs.get(num, 0)
        
        for num, freq in freqs.items():
            elements[freq].append(num)
        
        sol = []
        for i in range(len(elements) - 1, 0, -1):
            for num in elements[i]:
                sol.append(num)
                if len(sol) == k:
                    return sol
        
        