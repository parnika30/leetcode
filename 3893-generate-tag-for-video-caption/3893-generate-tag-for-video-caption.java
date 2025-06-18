class Solution {
    public String generateTag(String caption) {
        StringBuilder ans = new StringBuilder("#");
        for(int i=0;i<caption.length(); i++){
            char current = caption.charAt(i);
            if(current == ' ') continue;
            if(i>0 && caption.charAt(i-1) == ' '){
                if(Character.isLowerCase(current)){
                    current = Character.toUpperCase(current);
                }
            }else if(Character.isUpperCase(current)){
                    current = Character.toLowerCase(current);
            }
            ans.append(current);
        }
        if (ans.length() > 1) {
            ans.setCharAt(1, Character.toLowerCase(ans.charAt(1)));
        }
        //if(ans.length() >= 1) ans.charAt(1) =  Character.toLowerCase(ans.charAt(1));
        return ans.length() > 100 ? ans.substring(0, 100) : ans.toString();
        //return ans;
    }
}