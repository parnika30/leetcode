class Solution {
    public int getLeastFrequentDigit(int n) {
        List<Integer> list = new ArrayList<>();
        String s = String.valueOf(n);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            int d = s.charAt(i) - '0';
            map.put(d, map.getOrDefault(d,0)+1);
        }

        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer,Integer> i : map.entrySet()){
            int value = i.getValue();
            min = Math.min(min, value);
        }


        //7->1, 2->1, 3->2, 4->2, 5->1, 1->2
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> i : map.entrySet()){
            if(i.getValue() == min){
                result = Math.min(result, i.getKey());
            }
        }

        return result;
    }
}