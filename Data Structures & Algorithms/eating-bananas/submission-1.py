class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lower = 1
        upper = max(piles)
        sol = upper

        while lower <= upper:
            k = (lower + upper) // 2

            totalTime = 0
            for p in piles:
                totalTime += math.ceil(p / k)
            if totalTime <= h:
                sol = k
                upper = k - 1
            else:
                lower = k + 1
        
        return sol