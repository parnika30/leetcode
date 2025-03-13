class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n+1];
        int[] outgoing = new int[n+1];

        for(int[] t : trust){
            outgoing[t[0]]++;  //Increments the number of people that person a trusts (outgoing trust count).
            incoming[t[1]]++; // Increments the number of people who trust person b (incoming trust count).
        }

        for(int i = 1; i<=n ; i++){
            if(incoming[i] == n-1 && outgoing[i] == 0) return i;
        }
        return -1;
    }
}