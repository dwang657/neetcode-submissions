class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) {
                return false;
            }
            if (freq.get(c) <= 0) {
                return false;
            }
            freq.put(c, freq.get(c) - 1);
        }
        for (int value : freq.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
