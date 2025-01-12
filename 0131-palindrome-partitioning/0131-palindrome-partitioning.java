class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(s, 0 , result, list);
        return result;
    }

    private boolean isPalindrome (String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    private void partition(String s, int index , List<List<String>> result, List<String> list){
        //base condition
        if(index == s.length()){
            result.add((new ArrayList<>(list)));
            return;
        }

        for(int i = index; i<s.length(); i++){
            //start from index, go to where we want to have the first partition, i.e. i
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                partition(s, i+1 , result, list);
                list.remove(list.size()-1); //remove last element while backtracking
            } 
        }
    }
}