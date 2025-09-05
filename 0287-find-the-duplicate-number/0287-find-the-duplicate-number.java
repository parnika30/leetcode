class Solution {
    public int findDuplicate(int[] nums) {
        // HashSet<Integer>duplicate=new HashSet<Integer>();
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(duplicate.contains(nums[i]))
        //         return nums[i];
        //     else
        //         duplicate.add(nums[i]);
        // }
        // return -1;


        int slow = nums[0], fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow==fast) break;
        }

        int slow2 = nums[0];
        while(slow!=slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}