class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for str in strs:
            sortedStr = "".join(sorted(str))
            anagrams[sortedStr].append(str)
        return list(anagrams.values())