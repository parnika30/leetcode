/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node dfsClone(Node node, HashMap<Node,Node> oldToNew){
        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);
        
        //traverse through the neighbors
        for(Node neighbors : node.neighbors){
            if(!oldToNew.containsKey(neighbors)){
                //neighbors not cloned
                newNode.neighbors.add(dfsClone(neighbors,oldToNew));
            }else{ //neighbors cloned
                newNode.neighbors.add(oldToNew.get(neighbors));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null; //neighbours can't be null once recursion starts
        HashMap<Node,Node> oldToNew = new HashMap<>(); //mapping is old -> new
        return dfsClone(node,oldToNew);
    }
}