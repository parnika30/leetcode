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
    int count = 0 ; //for nodes visited
    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = findSmallest(root,k);
        if(res == null) return 0;
        return res.val; 
    }

        private TreeNode findSmallest(TreeNode root, int k){ ///in-order traversal
            if(root == null){
                return null;
            }
            TreeNode left = findSmallest(root.left, k);
            if(left != null){
                return left;  // If found in left subtree
            }
            count ++; 
            if(count == k) return root;   //If not found, we check the current node to see if it’s the kth smallest.
            return findSmallest(root.right, k); //f still not found, we return the right subtree
        }
}