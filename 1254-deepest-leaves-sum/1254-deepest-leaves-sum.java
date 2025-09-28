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
    public int deepestLeavesSum(TreeNode root) {
        // use bfs
        // take sum at each level, reset sum for each level
        // the last sum will be the sum for last level. 

        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;

        if(root == null) return 0;

        q.offer(root);
        while(!q.isEmpty()){
            sum = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            } 
        }

        return sum;
    }
}