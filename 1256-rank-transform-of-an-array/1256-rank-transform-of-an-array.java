class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = arr[i];
        }

        Arrays.sort(temp);
        HashMap<Integer, Integer> numToVal = new HashMap<>();
        int rank = 1;

        for(int i=0;i<n;i++){
            if(!numToVal.containsKey(temp[i])){
                numToVal.put(temp[i], rank);
                rank++;
            }
        }

        for(int i=0;i<n;i++){
            arr[i] = numToVal.get(arr[i]);
        }
        return arr;
    }
}