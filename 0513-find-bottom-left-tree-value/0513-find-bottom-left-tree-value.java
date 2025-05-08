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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        leftSideView(root, finalList, 0); //node pe 0th level rahgea
        return finalList.get(finalList.size()-1);
    }

    public void leftSideView(TreeNode root, List<Integer> finalList, int level) {
        if(root == null) return;

        if(finalList.size() == level){
            finalList.add(root.val);
        }

        leftSideView(root.left, finalList, level+1);
        leftSideView(root.right, finalList, level+1);
    }
}