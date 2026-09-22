class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {} # create dictionary to calculate frequencies of elements

        # create list of lists where the list at index i contains all the elements
        # with a frequency of i
        elements = [[] for i in range(len(nums) + 1)]

        # calculate the frequencies for each element
        for num in nums:
            freqs[num] = 1 + freqs.get(num, 0)
        
        # for each key/value pair in the freq table, add the element to the list
        # at the index that corresponds to its frequency
        for num, freq in freqs.items():
            elements[freq].append(num)
        
        sol = []
        # iterate backwards from the last index in elements (most frequent)
        for i in range(len(elements) - 1, 0, -1):
            # iterate through every element with that frequency
            for num in elements[i]:
                sol.append(num)
                # return when sol has k elements
                if len(sol) == k:
                    return sol
        
        