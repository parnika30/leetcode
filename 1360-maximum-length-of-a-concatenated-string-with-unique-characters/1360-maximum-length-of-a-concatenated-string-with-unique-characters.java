class Solution {
    public int maxLength(List<String> arr) {
        return f(0,arr,"");
    }

    private static int f(int ind, List<String> arr, String s){
        if(!unique(s)) return 0;

        int max = s.length();
        for(int i =ind; i<arr.size(); i++){
            max = Math.max(max, f(i+1, arr, s + arr.get(i)));
        }
        return max;
    }

    private static boolean unique(String s){
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)) return false;
        }
        return true;
        
    }
}