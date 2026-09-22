class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<HashMap<Character, Integer>, List<String>> freqs = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> map = helper(str);
            if (freqs.containsKey(map)) {
                freqs.get(map).add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                freqs.put(map, strings);
            }
        }
        for (List<String> strings : freqs.values()) {
            list.add(strings);
        }
        return list;
    }

    private HashMap<Character, Integer> helper(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
}
