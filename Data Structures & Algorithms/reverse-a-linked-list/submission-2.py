# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head

        while curr:
            # save next node so we can use it later
            temp = curr.next
            # set next to point to the prev node
            curr.next = prev
            # set prev to the current node for the next iteration
            prev = curr
            # set curr for the next iteration
            curr = temp

        return prev



