class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        while(!heap.isEmpty()){
            int[] top = heap.poll();
            char c = (char) top[0];
            int freq = top[1];

            for(int i=0; i<freq; i++){
                sb.append(c);
            }
        }

        return sb.toString();


    }
}