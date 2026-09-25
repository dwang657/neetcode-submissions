class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False
        s1Count = {}
        for char in s1:
            s1Count[char] = 1 + s1Count.get(char, 0)

        l = 0
        s2Count = {}
        for r in range(len(s1)):
            if s2[r] in s1Count:
                s2Count[s2[r]] = 1 + s2Count.get(s2[r], 0)
        
        if s2Count == s1Count:
            return True

        for r in range(len(s1), len(s2)):
            if s2[l] in s1Count:
                s2Count[s2[l]] -= 1
            l += 1
            if s2[r] in s1Count:
                s2Count[s2[r]] = 1 + s2Count.get(s2[r], 0)
            if s2Count == s1Count:
                return True
        
                
        
        return False
        
