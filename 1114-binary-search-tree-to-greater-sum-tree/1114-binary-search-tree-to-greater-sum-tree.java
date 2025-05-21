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
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node!=null || !st.isEmpty()){
            while(node!=null){
                st.push(node);
                node = node.right;
            }
            node = st.pop(); //sabse recent right value, i.e. sabse last right node
            sum += node.val;
            node.val = sum;
            node = node.left; //phele right, fir left. 
        }

        return root;
    }
}