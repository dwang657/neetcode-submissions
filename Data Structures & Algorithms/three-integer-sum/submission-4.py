class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sol = []
        nums.sort()

        for i, num in enumerate(nums):
            # starting from index i, and checking indices to the right.
            # if current index is positive, no combination of numbers to the 
            # right will sum to 0
            if num > 0:
                break

            if i > 0 and num == nums[i - 1]:
                continue

            l = i + 1
            r = len(nums) - 1
            while l < r:
                threeSum = num + nums[l] + nums[r]
                if threeSum > 0:
                    r -= 1
                elif threeSum < 0:
                    l += 1
                else:
                    sol.append([num, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
        
        return sol