class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        for(int i=0; i<arr.length; i++){
            int diff = Math.abs(arr[i]-x);
            minHeap.add(new int[]{diff, arr[i]}); //adding the pair
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<k; i++){
            result.add(minHeap.poll()[1]);
        }
        Collections.sort(result);
        return result;
        
    }
}