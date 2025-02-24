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
    HashMap<Integer, Integer> hp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = inorder.length;
        for(int i = 0 ; i < n ; i++){
            hp.put(inorder[i], i); //key -> element, va -> index
        }
        return buildFromInAndPre(preorder, 0, n -1, inorder, 0, n-1);
    }

        private TreeNode buildFromInAndPre(int[] preorder, int i1, int i2, int[] inorder, int j1, int j2){
        if(i1 > i2 || j1 > j2) return null; //pointers cross each other

        TreeNode root = new TreeNode(preorder[i1]); //preorder ka 1st element will always be the root for new tree.

        if(i1 == i2){
            return root; //checking for a leaf node; no building of left/riht subtree
        }
        int left = preorder[i1];      //in pre
        int mid = hp.get(left);         // in map, gets index
        int leftSize = (mid - j1);      //in inorder

        //construct sub trees :

        root.left = buildFromInAndPre(preorder, (i1 + 1), (i1 + leftSize), inorder, j1, (mid-1));
        root.right = buildFromInAndPre(preorder, (i1 + leftSize + 1), i2, inorder, ( mid + 1), j2);

        return root;
    }
}