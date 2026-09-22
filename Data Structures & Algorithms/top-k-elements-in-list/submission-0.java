class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int key : count.keySet()) {
            freq[count.get(key)].add(key);
        }

        int[] topK = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                topK[index++] = num;
                if (index == k) {
                    return topK;
                }
            }
        }

        return null;
    }
}
