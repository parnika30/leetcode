class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            set.add(freq);
        }

        if(set.size()<map.size()) return false;
        return true;
    }
}