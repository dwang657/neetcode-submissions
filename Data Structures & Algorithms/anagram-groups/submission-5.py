class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list) # defaultdict(list) maps keys to lists
        for str in strs:
            # sorted(str) returns a sorted list of the chars in str
            # "<separator>".join(list) joins the elements in list with the
            # specified separator
            sortedStr = "".join(sorted(str)) 
            anagrams[sortedStr].append(str)
        
        return list(anagrams.values())