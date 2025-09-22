class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // List<Integer>[] bucket = new List [nums.length+1];
        // HashMap<Integer, Integer> hm = new HashMap<>();
        
        // //insert into hm 
        // for(int n : nums){
        //     hm.put(n, hm.getOrDefault(n, 0)+1);
        // }

        // for(int key: hm.keySet()){  //traverse thru hm 
        //     int freq = hm.get(key); // get freq of key
        //     if(bucket[freq]==null){
        //         bucket[freq] = new ArrayList<>();  
        //         // initialise new arryalist to each bucket
        //     }
        //     bucket[freq].add(key); //add freq of each key to bucket in arraylist 
        // }

        // int[] res = new int[k]; //result array
        // int pos = 0; // position of elements of list inside the bucket

        // for(int i = bucket.length-1; i>=0; i--){ //traverse from last
        //     if(bucket[i] != null){
        //         //traverse thru list of the bucket 
        //         for(int j =0 ; j < bucket[i].size() && pos<k; j++){ 
        //             res[pos] = bucket[i].get(j);  //get the elements from the list
        //             pos++; //increment the postition of list 
        //         }
        //     } 
        // }

        // return res;

        HashMap<Integer, Integer> hm = new HashMap<>();        
        for(int n : nums){
            hm.put(n, hm.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
        for(int i : hm.keySet()){
            maxheap.offer(i);
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = maxheap.poll();
        }
        return ans;
    }
}