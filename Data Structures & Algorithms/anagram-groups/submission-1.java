class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqs = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!freqs.containsKey(sorted)) {
                freqs.put(sorted, new ArrayList<>());
            }
            freqs.get(sorted).add(s);
        }
        return new ArrayList<>(freqs.values());
    }
}
