class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int maxF = 0, count = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxF = Math.max(maxF, entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxF){
                count++;
            }
        }

        return count * maxF;
    }
}

// map
// 1 -> 2
// 2 -> 2
// 3 -> 1
// 4 -> 1 

// maxF = 0
// keyset mei traverse krenge, maxF = max(max, map.getKey(keyset1)) -> (0,2) => 2
// if(entry.getvalue()==max)
// occ = entry.getKey()
// count += occ.getValue(); 