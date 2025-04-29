/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//watch striver video 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val){ //both nodes lie on left
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){ //both nodes lie on right
            return lowestCommonAncestor(root.right, p, q);
        }return root; //intersection point where it splits.   
    }
}