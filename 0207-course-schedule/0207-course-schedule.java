class Solution {
    //using kahn's algo - topo bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] indeg = new int[numCourses];
        //figuring out the indegree of each element 
        for(int i =0; i< numCourses ;i++){
            for(int ele : adj.get(i)){
                indeg[ele]++; //indeg[1]++ (incoming edge to 1)
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =0; i< numCourses ;i++){
            if(indeg[i]==0) q.add(i); //start from the ele whose indeg is 0
        }
            
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek(); //first ele whose indeg is 0
            q.remove();
            topo.add(node);
            
            //since node is in topo sort, remove from indegree
            for(int ele : adj.get(node)){
                indeg[ele]--;
                if(indeg[ele] == 0) q.add(ele);
            }
        }
        
        //topo sort will always have same number of elements, 
        //so if the number of ele are less than or greater than numCourses,
        //it has a cycle, i.e. it can be arranged in more than 1 ways
        if(topo.size()==numCourses) return true;
        else return false;
    }
}