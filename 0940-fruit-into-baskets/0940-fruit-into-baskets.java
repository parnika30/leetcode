class Solution {
    public int totalFruit(int[] fruits) {
        int l=0,r=0, maxLen =0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r<fruits.length){
            //Move the right pointer, adding each fruit to the map and updating its count.
            map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);

            if(map.size() > 2){ //jaise hi 2 se zyada number hojayenge
                while(map.size() > 2){
                    // move the left pointer and decrease counts until only 2 types remain.
                    map.put(fruits[l], map.getOrDefault(fruits[l],0)-1);


//check if count = zero after shrinking the window from the left. 
//If 0 => fruit type isn’t in our current window anymore, so we can safely remove it from the map.
                    if(map.get(fruits[l])==0){
                        map.remove(fruits[l]);   //left se counrt ko decrease karo
                    }
                    l++;

                }
            }
            if(map.size() <= 2){
                maxLen = Math.max(maxLen, r-l +1);
            }
            r++;
        }

        return maxLen;
    }
}

//max length subarray with atmost 2 types of numbers

//tc : O(2n)
