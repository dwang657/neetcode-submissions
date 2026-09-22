class Solution {
    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String odd = helper(s, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            String even = helper(s, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    private String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
