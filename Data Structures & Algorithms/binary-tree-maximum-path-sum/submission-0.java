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

    public int util(TreeNode root, int[] maxiSum){
        if(root == null){
            return 0;
        
        }
        int lh = Math.max(0, util(root.left, maxiSum));
        int rh = Math.max(0, util(root.right, maxiSum));
        maxiSum[0] = Math.max(maxiSum[0], lh+rh+root.val);
        return Math.max(lh,rh) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        
        int[] maxiSum = {Integer.MIN_VALUE};
        util(root, maxiSum);
        return maxiSum[0];
        
    }
}
