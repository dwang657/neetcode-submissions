class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(9):
            seen = set()
            for i in range(9):
                if board[row][i] != "." and board[row][i] in seen:
                    return False
                seen.add(board[row][i])
        
        for col in range(9):
            seen = set()
            for i in range(9):
                if board[i][col] != "." and board[i][col] in seen:
                    return False
                seen.add(board[i][col])

        # squares
        # [0, 1, 2]
        # [3, 4, 5]
        # [6, 7, 8]
        for square in range(9):
            seen = set()
            for i in range(3):
                for j in range(3):
                    row = (square // 3) * 3 + i
                    col = (square % 3) * 3 + j

                    if board[row][col] != "." and board[row][col] in seen:
                        return False
                    seen.add(board[row][col])

        return True









