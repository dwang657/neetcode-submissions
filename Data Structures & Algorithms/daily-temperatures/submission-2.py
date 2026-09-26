class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = [] # stack of indices (days)
        result = [0] * len(temperatures) 
        # the stack will contain temperatures in decreasing order
        # if the curr temp is greater than the temp at the top of the stack,
        # pop temp off stack and update its index in result
        # repeat this while current temp is greater than temp in stack
        # then add current temp to stack
        #
        # the stack will always contain the largest temps you've encountered in 
        # decreasing order
        #
        # when you look at curr temp, you pop every temp in the stack that is
        # less than it and update those indices using curr index and index in 
        # stack
        # 
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        
        return result