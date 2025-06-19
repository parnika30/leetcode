class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        //while loop is not used here because initially slow and 
        //fast pointer will be equal only, so the loop won't run.

        // move slow by 1 step (1 call to square)
        // move fast by 2 steps (2 calls to square)
        // loop continues until both meet — i.e., a cycle is detected

        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);

        return slow==1; //If slow == fast and slow == 1, it's a happy number.
    }

    private int square(int n){
        int ans = 0;
        while(n>0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }

        return ans;
    }
}