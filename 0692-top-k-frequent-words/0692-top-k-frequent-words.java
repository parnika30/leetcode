class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer>map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int freq = map.get(b) - map.get(a); // higher freq first
                if (freq == 0) {
                    return a.compareTo(b); // lexicographically smaller first
                }
                return freq;
            }
        );

        maxHeap.addAll(map.keySet());

        ArrayList<String >res = new ArrayList<>();
        int ind = 0;

        for(int i =0; i<k;i++){
            String word = maxHeap.poll();
            res.add(word);
        }

        return res;

    }
}