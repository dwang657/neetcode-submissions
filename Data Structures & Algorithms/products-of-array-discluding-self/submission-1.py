class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [1 for i in range(len(nums))] # initialize output to be all 1s
        
        for i in range(1, len(nums)):
            # set output[i] to its prefix product
            output[i] *= output[i - 1] * nums[i - 1]
        
        suffix = 1
        for i in range(len(nums) - 2, -1, -1):
            suffix *= nums[i + 1]
            output[i] *= suffix
        
        return output
            