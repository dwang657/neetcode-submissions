class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqs = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars); 
            if (!freqs.containsKey(sorted)) {
                freqs.put(sorted, new ArrayList<String>());
            }
            freqs.get(sorted).add(s);
        }
        return new ArrayList<>(freqs.values());
    }
}
