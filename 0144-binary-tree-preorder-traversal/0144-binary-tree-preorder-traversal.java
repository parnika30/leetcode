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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preTraversal(root, res);
        return res;
    }
    public void preTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preTraversal(root.left, res);
        preTraversal(root.right, res);

        //node, left, right
    }
}