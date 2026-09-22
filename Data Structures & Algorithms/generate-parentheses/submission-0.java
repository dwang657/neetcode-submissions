class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        dfs(0, 0, "", n, output);
        return output;
    }

    private void dfs(int numOpen, int numClosed, String s, int n, List<String> output) {
        if (numOpen + numClosed == n * 2 && numOpen == numClosed) {
            output.add(s);
            return;
        }

        if (numOpen < n) {
            dfs(numOpen + 1, numClosed, s + '(', n, output);
        }

        if (numClosed < numOpen) {
            dfs(numOpen, numClosed + 1, s + ')', n, output);
        }
    }
}
