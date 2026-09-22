class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                if (left == right) {
                    return sol;
                } else {
                    sol[0] = left + 1;
                    sol[1] = right + 1;
                    break;
                }
            }
        }

        return sol;
    }
}
