class TrieNode():
    def __init__(self):
        self.children = {}
        self.isWord = False
class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
        

    def addWord(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isWord = True
    
    def search(self, word: str) -> bool:
        def dfs(i, root):
            curr = root
            for j in range(i, len(word)):
                c = word[j]

                if c == ".":
                    for child in curr.children.values():
                        if dfs(j+1, child):
                            return True
                    return False
                else:
                    if c not in curr.children:
                        return False
                curr = curr.children[c]
            
            return curr.isWord
        
        return dfs(0, self.root)
    
                
        