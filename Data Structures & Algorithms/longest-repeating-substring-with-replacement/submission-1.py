class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {} 
        sol = 0

        l = 0
        maxFreq = 0

        for r in range(len(s)):
            count[s[r]] = 1 + count.get(s[r], 0) # update freq of each char
            maxFreq = max(maxFreq, count[s[r]]) # keep track of most frequent char
                                                # in window

            # want to replace chars that are not the most frequent char.
            # length of window - number of most frequent char = number of chars
            # that need to be replaced.
            # while chars that need replacement > k, shrink window
            while (r - l + 1) - maxFreq > k:
                count[s[l]] -= 1
                l += 1
            sol = max(sol, r - l + 1)
        
        return sol