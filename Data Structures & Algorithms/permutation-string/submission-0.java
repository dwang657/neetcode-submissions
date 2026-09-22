class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> s2Freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i), 0) + 1);
            s2Freq.put(s2.charAt(i), s2Freq.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s1Freq.equals(s2Freq)) {
            return true;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char cRight = s2.charAt(right);
            s2Freq.put(cRight, s2Freq.getOrDefault(cRight, 0) + 1);

            char cLeft = s2.charAt(left);
            s2Freq.put(cLeft, s2Freq.get(cLeft) - 1);

            if (s2Freq.get(cLeft) == 0) {
                s2Freq.remove(cLeft);
            }

            if (s2Freq.equals(s1Freq)) {
                return true;
            }

            left++;
        }

        return false;
    }
}
