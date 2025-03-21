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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> finalList = levelOrder(root);
        List<Integer> rightList = new ArrayList<Integer>();

        for(List<Integer> level : finalList){
            rightList.add(level.get(level.size()-1));
        }
        return rightList;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();

        if(root == null) return finalList; //khali list

        que.add(root);//insert the root in que

        while(!que.isEmpty()){
            int size = que.size();  // inside the loop : size is updated at the start of each level.

            //sublist inside the final list that will get created for each level of tree. 
            List<Integer> subList = new ArrayList<Integer>(); 
            
            for(int i = 0; i <size; i++){
                if(que.peek().left!=null){
                    que.add(que.peek().left);  //putting the left of each non empty root inside the queue
                }
                if(que.peek().right!=null){
                    que.add(que.peek().right); //putting the right of each non empty root inside the queue
                }
                subList.add(que.remove().val); //adding the value of the roots in the sub list. <[_ , _]>
            }
            finalList.add(subList); //adding in final list

        }
        return finalList; 
    }


}