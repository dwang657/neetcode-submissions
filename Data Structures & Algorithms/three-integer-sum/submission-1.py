class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sol = []
        nums.sort()

        # enumerate elements of nums
        for i, num in enumerate(nums):
            # if the smallest number is positive, then impossible for 3 numbers
            # to sum to 0
            if num > 0:
                break
            
            # skip number if we've already found sols with it
            if i > 0 and num == nums[i - 1]:
                continue
            
            # find all solutions with num and current index
            # use pointers to search all indices to the right
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