class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 1, h = n, min = 0;
        while(l<=h){
            int mid = l + (h - l) / 2; //2, 4
            if(window(mid, nums, target)){ //4
                min = mid; //4
                h = mid - 1;
            }else{
                l = mid+1; //3
            }
        }

        return min; 
    }

    public boolean window(int len, int[] nums, int target){ //4,nums,7
        int sum =0, i=0,j=0;
        int max = Integer.MAX_VALUE;
        while(j<nums.length){
            sum += nums[j]; //2,5,6, 8; 
            if(j-i+1==len){ //2==2, 3!=2, 
                if(sum >= target) return true; //8>7
                sum -= nums[i];//8-2 = 6
                i++; //1
            }
            j++;
        }
        return false;
    }

}




//[2,3,1,2,4,3]