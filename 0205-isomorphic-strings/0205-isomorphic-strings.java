class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!m1.containsKey(s.charAt(i))){
                m1.put(s.charAt(i), i); //f:0, o:1
            }
            if(!m2.containsKey(t.charAt(i))){
                m2.put(t.charAt(i), i); //b:0, a:1, r:2
            }
            if(!m1.get(s.charAt(i)).equals(m2.get(t.charAt(i)))){
                return false;
            }
        }

        return true;

    
    }
}