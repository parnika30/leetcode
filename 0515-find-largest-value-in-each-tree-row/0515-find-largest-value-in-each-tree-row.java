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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE; 
            //initialize max to Integer.MIN_VALUE at the start of each level

            for(int i =0; i<size; i++){
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left!=null){
                    q.add(node.left);
                }if(node.right!=null){
                    q.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}