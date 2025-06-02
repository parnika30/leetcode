class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n-k+1];

        for(int i=0; i<= n-k; i++){ //start from 0->window
            HashMap<Integer,Integer> map = new HashMap<>(); 
            for(int j =i; j< i+k ; j++){ //counting freq in each window
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a,b) -> {
                    if(!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue(); //higher freq first
                    return b.getKey() - a.getKey(); //higher value first
                }
            );
            heap.addAll(map.entrySet()); //storing in heap

            int sum = 0, count =0; //get top x from heap -> for which we need to sum
            while(count<x && !heap.isEmpty()){
                Map.Entry<Integer, Integer> entry = heap.poll();

                //multiply the element's value by how many times it appears, and sum those up.
                sum += (entry.getKey() * entry.getValue()); 
                count ++;
            }
            answer[i] = sum;
            
        }
        return answer;
    }
}


//tc -> O(k) -> build map
// + O(d) -> heap build
// + 0(x log d) -> extract top x elements
//  total -> O(k + x log d)