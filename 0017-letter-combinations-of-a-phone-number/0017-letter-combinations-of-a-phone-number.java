class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();

        if(digits.length()==0 || digits == null)return res;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, "", map, res, digits);
        return res;

    }

    private void backtrack(int ind, String curr, HashMap<Character, String> map, List<String> res, String digits){
        if(digits.length() == curr.length()){
            res.add(curr);
            return;
        }

        String combo = map.get(digits.charAt(ind));
        for(char c : combo.toCharArray()){
            backtrack(ind+1, curr+c, map, res, digits);
        }
    }

}

//tc -> O(k^n⋅n)