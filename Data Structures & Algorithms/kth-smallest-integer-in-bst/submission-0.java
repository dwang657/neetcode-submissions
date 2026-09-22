/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, k);
        return list.get(list.size() - 1);
    }

    private void helper(TreeNode curr, List<Integer> list, int k) {
        if (curr != null && list.size() < k) {
            helper(curr.left, list, k);
            if (list.size() < k) {
                list.add(curr.val);
            }
            if (list.size() < k) {
                helper(curr.right, list, k);
            }
        }
    }
}
