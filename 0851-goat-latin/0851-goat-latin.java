class Solution {
    public String toGoatLatin(String sentence) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder sb = new StringBuilder();
        String suff = "";
        for(String str : sentence.split(" ")){
            suff += 'a';

            if(!set.contains(str.charAt(0))){
                str = str.substring(1) + str.charAt(0);
            }

            sb.append(str).append("ma").append(suff).append(' ');

        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

