class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hs = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if(!hs.containsKey(sorted)){
                hs.put(sorted, new ArrayList<>());
            }

            hs.get(sorted).add(s);
        }
        return new ArrayList<>(hs.values());
    }
}