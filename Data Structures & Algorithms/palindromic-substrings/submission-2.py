class Solution:
    def countSubstrings(self, s: str) -> int:
        sol = 0
        for i in range(len(s)):
            sol += self.countPali(s, i, i)
            sol += self.countPali(s, i, i + 1)
        return sol
    
    def countPali(self, s, l, r):
        sol = 0
        while l >= 0 and r < len(s) and s[l] == s[r]:
            sol += 1
            l -= 1
            r += 1
        return sol

