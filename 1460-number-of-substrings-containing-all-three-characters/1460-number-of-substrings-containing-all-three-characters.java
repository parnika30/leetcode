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


        for (int i = 0; i < n; i++) {
            last[s.charAt(i)-'a'] = i;
            int min1 = Math.min(last[0],last[1]);
            count = count+(1 + Math.min(min1,last[2]));
        }
        return count;
    }
}