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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode curr, int max) {
        if (curr == null) {
            return 0;
        }

        if (curr.val >= max) {
            return 1 + helper(curr.left, curr.val) + helper(curr.right, curr.val);
        } else {
            return helper(curr.left, max) + helper(curr.right, max);
        }
    }
}
