class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        String sol = "";

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }

            while (within(tMap, sMap)) {
                if (sol.equals("") || sol.length() > right - left + 1) {
                    sol = s.substring(left, right + 1);
                }
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }

        return sol;
    }

    private boolean within(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (char c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }

        return true;
    }
}