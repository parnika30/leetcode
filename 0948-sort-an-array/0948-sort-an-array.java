class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int l ,int h){
        if(l<h){
            int m = l + (h - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, h);
            merge(nums, l, m , h);
        }
    }

    private static void merge(int[] nums, int l, int m, int h){
        int n1 = m-l+1;
        int n2 = h-m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++) left[i] = nums[l+i];
        for(int j=0;j<n2;j++) right[j] = nums[m+1+j];

        int i=0,j=0,k=l;
        
        while(i < n1 && j< n2){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            }else{
                nums[k] = right[j];
                j++;
            }
            k++;  
        }

        while(i < n1){
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}