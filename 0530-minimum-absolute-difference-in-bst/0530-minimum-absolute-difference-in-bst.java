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

    public TreeNode prev=new TreeNode();
    public int ans=Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(prev!=null){
            ans = Math.min(ans, root.val - prev.val);
        }
        prev = root;
        dfs(root.right);
    }
}