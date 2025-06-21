// class Solution {
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         Set<String> set = new HashSet<>();
//         int count = 0;

//         //ensures all building coordinates are in your set before checking neighbors
//         for(int[] b : buildings){
//             set.add(b[0]+ "," +b[1]);
//         }

//         for(int[] b : buildings){
//             int r = b[0]; 
//             int c = b[1];
//             boolean up = false;
//             boolean down = false;
//             boolean left = false;
//             boolean right = false;

//              for (int[] neigh : buildings) {
//                 if(neigh[1] == c && neigh[0] < r ) up = true; // same column, row is -
//                 if(neigh[1] == c && neigh[0] > r) down = true; // same column, row is +
//                 if(neigh[1] < c && neigh[0] == r) left = true;
//                 if(neigh[1] > c && neigh[0] == r) right = true;
//             }

//             if(up && down && left && right){
//                 count++; 
//             }
//         }
//         return count;
//     }
// }



class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, TreeSet<Integer>> rToC = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> cToR = new HashMap<>();
        int count = 0;

        //ensures all building coordinates are in your set before checking neighbors
        for(int[] b : buildings){
            rToC.computeIfAbsent(b[0], x->new TreeSet<>()).add(b[1]);
            cToR.computeIfAbsent(b[1], x->new TreeSet<>()).add(b[0]);
        }

        for(int[] b : buildings){
            int r = b[0]; 
            int c = b[1];

            TreeSet<Integer> cols = rToC.get(r);
            TreeSet<Integer> rows = cToR.get(c);

            boolean up = rows.lower(r)!=null;
            boolean down = rows.higher(r)!=null;
            boolean left = cols.lower(c)!=null;
            boolean right = cols.higher(c)!=null;

            if(up && down && left && right){
                count++; 
            }
        }
        return count;
    }
}