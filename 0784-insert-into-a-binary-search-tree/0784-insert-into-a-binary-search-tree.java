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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode node = new TreeNode(val);

        while(curr!=null){ //to check which side to insert 
            parent = curr;
            if(curr.val < val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        //to check where(which position) to insert
        if(parent == null)return node;
        if(val > parent.val){
            parent.right = node;
        }else{
            parent.left = node;
        }

        return root;
    }
}