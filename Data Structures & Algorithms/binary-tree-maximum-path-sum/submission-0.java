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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{root.val};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode curr, int[] max) {
        if (curr == null) {
            return 0;
        }
        int left = Math.max(helper(curr.left, max), 0);
        int right = Math.max(helper(curr.right, max), 0);
        max[0] = Math.max(max[0], curr.val + left + right);
        return curr.val + Math.max(left, right);
    }
}





