class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced =0, n = fruits.length; 
        boolean[] used = new boolean[n]; 
        for(int i=0; i < n; i++){
            boolean placed= false;
            for(int j=0; j < n; j++){
                if(!used[j] && fruits[i]<=baskets[j]){
                    placed = true;
                    used[j] = true;
                    break;
                }
            }

            if(!placed){
                unplaced++;
            }
        }
        
        return unplaced;
    }
}