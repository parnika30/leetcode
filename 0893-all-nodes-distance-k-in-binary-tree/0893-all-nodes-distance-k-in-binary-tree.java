/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> graph;
    HashSet<Integer> visited;
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        res = new ArrayList<>();
        visited = new HashSet<>();

        buildGraph(root, null); //root won't have any parent => null
        visited.add(target.val);
        dfs(target.val, 0, k);

        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent){
        if(node != null && parent != null){
            graph
            .computeIfAbsent(node.val, k -> new ArrayList<>())
            .add(parent.val);

            graph
            .computeIfAbsent(parent.val, k -> new ArrayList<>())
            .add(node.val);
        }

        if(node.left != null){
            buildGraph(node.left, node);
        }

        if(node.right!=null){
            buildGraph(node.right, node);
        }
    }

    private void dfs(int curr, int distance, int k){
        if(distance == k){
            res.add(curr);
            return;
        }

        for(int neigh : graph.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neigh)){
                visited.add(neigh);
                dfs(neigh, distance+1, k);
            }
        }
    }
}