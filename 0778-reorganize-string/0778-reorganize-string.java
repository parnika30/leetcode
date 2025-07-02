class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxheap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder(); 
        int n = s.length();

        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxheap.offer(entry); 
        }

        Map.Entry<Character, Integer> prev = null;

        while(!maxheap.isEmpty()){
            Map.Entry<Character, Integer> curr = maxheap.poll();
            int freq = curr.getValue();
            sb.append(curr.getKey());
            curr.setValue(freq - 1);

            if(prev!=null && prev.getValue() >0){       
                maxheap.offer(prev);
            }
            prev = curr; 
        }
        if(sb.length() == s.length()) return sb.toString();
        else return "";

    }
}


//tc -> N logK