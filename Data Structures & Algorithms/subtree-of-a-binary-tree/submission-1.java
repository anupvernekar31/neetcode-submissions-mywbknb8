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
// class Solution {
//     public boolean isSubtree(TreeNode s, TreeNode t) {
//         Queue<TreeNode> nodes = new ArrayDeque<>();
//         nodes.offer(s);
//         while (!nodes.isEmpty()) {
//             TreeNode node = nodes.poll();
//             if (isSameTree(node, t)) {
//                 return true;
//             }
//             if (node.left != null) {
//                 nodes.offer(node.left);
//             }
//             if (node.right != null) {
//                 nodes.offer(node.right);
//             }
//         }
//         return false;
//     }

//     public boolean isSameTree(TreeNode s, TreeNode t) {
//         if (s == null && t == null) {
//             return true;
//         }
//         if (s == null || t == null) {
//             return false;
//         }
//         if (s.val != t.val) {
//             return false;
//         } else {
//             return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
//         }
//     }
// }

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}