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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        int n = postorder.length;
        for(int i = 0 ; i < n ; i++){
            hp.put(postorder[i], i); //key -> element, va -> index
        }
        return buildTree(preorder, 0, n -1, postorder, 0, n-1);
    }

    private TreeNode buildTree(int[] preorder, int i1, int i2, int[] postorder, int j1, int j2){
        if(i1 > i2 || j1 > j2) return null; //pointers cross each other

        TreeNode root = new TreeNode(preorder[i1]); //preorder ka 1st element will always be the root for new tree.

        if(i1 == i2){
            return root; //checking for a leaf node; no building of left/riht subtree
        }
        int left = preorder[i1+1];       //in pre
        int mid = hp.get(left);          // in map, gets index
        int leftSize = (mid - j1) + 1;   //in post

        //construct sub trees :

        root.left = buildTree(preorder, (i1 + 1), (i1 + leftSize),
                              postorder, j1, mid);
        root.right = buildTree(preorder, (i1 + leftSize + 1), i2,
                               postorder,( mid + 1), (j2 -1));

        return root;
    }
}