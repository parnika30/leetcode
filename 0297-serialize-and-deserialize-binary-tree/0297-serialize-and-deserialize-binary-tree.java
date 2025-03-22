/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { //do a level order traversal
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("# ");
            }else{
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] val = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.add(root);

        for(int i =1; i< val.length; i++){
            TreeNode parent = q.poll();

            // Process left child
            if(!val[i].equals("#")){
                TreeNode left = new TreeNode (Integer.parseInt(val[i])); //creating a new left node for next child node 
                parent.left = left;
                q.add(left); //adding to queue for next traversal
            }

            // Process right child (ensure not out of bounds)    
            if(++i < val.length && !val[i].equals("#")){
                TreeNode right = new TreeNode (Integer.parseInt(val[i])); //creating a new right node for next child node 
                parent.right = right;
                q.add(right); //adding to queue for next traversal 
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));