class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sFreq = new HashMap<Character, Integer>();
        Map<Character, Integer> tFreq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            sFreq.put(s.charAt(i), sFreq.getOrDefault(s.charAt(i), 0) + 1);
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sFreq.equals(tFreq);
    }
}
