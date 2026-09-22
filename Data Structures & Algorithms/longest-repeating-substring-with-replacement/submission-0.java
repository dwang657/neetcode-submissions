class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            // keep track of max frequency 
            maxFreq = Math.max(maxFreq, freq.get(c));

            // if size of window is <= maximum frequency + k, then window can be all character of max freq
            // if size of window > max freq + k, then entire window cannot be same character, so shrink window
            while ((right - left + 1) - maxFreq > k) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
