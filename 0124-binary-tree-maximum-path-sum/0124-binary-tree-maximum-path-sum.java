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

    //intuition : 
        // dfs -> visit each node
        //Path Sum Calculation: currentPathSum = node.val + leftPath + rightPath.
        // Update Max: maxSum = Math.max(maxSum, currentPathSum) ensures we store the highest path sum encountered.
        // Return the max through one side using node.val + Math.max(leftPath, rightPath) to ensure a valid path.


    int val = 0;
    int max = Integer.MIN_VALUE;  //even negative path sums are considered
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        int leftPath = Math.max(0, dfs(root.left)); //0 for not considering -ve values
        int rightPath = Math.max(0, dfs(root.right));

        int currentPathSum = root.val + leftPath + rightPath;

        max = Math.max(max, currentPathSum);
        
        return Math.max(leftPath, rightPath) + root.val; //if we continue the path through this node, return the max
    }
}
