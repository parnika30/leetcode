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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for(int i = 0;i < size;i++){
                TreeNode curr = q.poll();

                //sibling check -> same parent
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)){
                            return false;
                    }
                }

                //x and y same level check
                if(curr.left != null){
                    q.add(curr.left);
                    if(curr.left.val == x) foundX = true;
                    if(curr.left.val == y) foundY = true;
                }
                if(curr.right != null){
                    q.add(curr.right);
                    if(curr.right.val == x) foundX = true;
                    if(curr.right.val == y) foundY = true;
                }
            }

            // If both are found at the same level and not siblings, they are cousins
            if (foundX && foundY) return true;

            // If one is found but not the other, they are not cousins
            if (foundX || foundY) return false;
        }
        return false;
    }
}