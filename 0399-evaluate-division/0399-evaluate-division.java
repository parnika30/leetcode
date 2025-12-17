class Pair{
    String variable;
    double value;

    Pair(String variable, double value){
        this.variable = variable;
        this.value = value;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build graph
        Map<String, List<Pair>> graph = new HashMap<>();
        for(int i =0;i<equations.size();i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];     

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b,val));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a,1.0/val));

            //"a" → [(b, 2.0), (c, 5.0)]
            //"b" → [(a, 0.5)]
            // Key → current variable
            // Value → list of neighbors + division weight
        }

        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            res[i] = bfs(src,target,graph);
        }
        return res;
    }

    private double bfs(String src, String target, Map<String, List<Pair>> graph){
        if(!graph.containsKey(src) || !graph.containsKey(target)){
            return -1.0;
        }//base case when either numerator or denominator is not present.
        
        Queue<Pair> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(new Pair(src,1.0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String node = curr.variable;
            double val = curr.value;
            if(node.equals(target)){
                return val;
            }

            for(Pair p : graph.get(node)){
                if(!vis.contains(p.variable)){
                    vis.add(p.variable);
                    q.offer(new Pair(p.variable, val * p.value));
                }
            }
        }

        return -1.0;
    }
}