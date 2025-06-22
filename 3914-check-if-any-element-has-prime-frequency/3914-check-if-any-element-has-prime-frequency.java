class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(isPrime(entry.getValue())){
                return true;
            }
        }
        return false;
    }

    private boolean isPrime(int n){
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0){
                return false;
            }
        return true;
    }
}