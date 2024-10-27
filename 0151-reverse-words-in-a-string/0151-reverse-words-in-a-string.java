class Solution {
    public String reverseWords(String s) {
        String[] str=s.split("\\s+");
        int n=str.length;
        String[] arr=new String[n];
        
        int index = 0;
        for(int i=n-1;i>=0;i--){
            arr[index]=str[i];
            index++;
        }
        return String.join(" ",arr).trim();
    }
}