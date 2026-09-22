class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        
        if (s.charAt(1) != '0') {
            dp[1] += 1;
        }
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) {
            dp[1] += 1;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length() - 1];
    }
}







