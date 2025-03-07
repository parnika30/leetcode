class Solution {
    public int[] closestPrimes(int left, int right) {
        if(left >  right){
            return new int[]{-1, -1};
        }

        // Sieve of Eratosthenes
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i*i <= right; i++){
            if(prime[i]){
                for(int j = i*i; j<=right; j+=i){
                    prime[j] = false;
                }
            }
        }

        //Collect primes in range [left, right]
        List<Integer> primeList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (prime[i]){
                primeList.add(i);
            }
        }

        //If fewer than 2 primes exist, return [-1, -1]
        if (primeList.size() < 2) {
            return new int[]{-1, -1};
        }
        

        //Find the closest prime pair
        int minDiff = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;

        for(int i =1 ; i< primeList.size(); i++){
            int diff = primeList.get(i) - primeList.get(i-1);
            if(diff < minDiff){
                minDiff = diff;
                num1 = primeList.get(i-1);
                num2 = primeList.get(i);
            }
        }

        return new int[]{num1, num2};

    }
}