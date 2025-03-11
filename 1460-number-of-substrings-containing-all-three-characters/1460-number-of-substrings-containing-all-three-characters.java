// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             HashSet<Character> hs = new HashSet<>();
//             for (int j = i; j < n; j++) {
//                 hs.add(s.charAt(j));
//                 if (hs.contains('a') && hs.contains('b') && hs.contains('c')) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// TC - O(n^2), SC - O(1)

// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             HashSet<Character> hs = new HashSet<>();
//             for (int j = i; j < n; j++) {
//                 hs.add(s.charAt(j));
//                 if (hs.contains('a') && hs.contains('b') && hs.contains('c')) {
//                     count = count + (n-j); //optimization -> 1 
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[] last = {-1, -1, -1}; 
        //last[0] stores the last index of 'a', last[1] for 'b', and last[2] for 'c'.


        for (int i = 0; i < n; i++) {
            last[s.charAt(i)-'a'] = i; //For every character s[i], update its last seen index.
            int min1 = Math.min(last[0],last[1]);
            count = count+(1 + Math.min(min1,last[2]));

            // Once we have seen 'a', 'b', and 'c', the minimum index among them tells us the starting index of the shortest valid substring ending at i.
        }
        return count;
    }
}