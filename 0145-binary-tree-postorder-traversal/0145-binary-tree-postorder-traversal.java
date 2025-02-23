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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postTraversal(root, res);
        return res;
    }
    public void postTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        postTraversal(root.left, res);
        postTraversal(root.right, res);
        res.add(root.val);

        //left, right, node
    }
}