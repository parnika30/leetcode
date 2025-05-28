//O(m+m)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = m-1, j = n-1;
        int point =  m + n - 1;
        int[] medianArr = new int[m+n];

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                medianArr[point--] = nums1[i--];
            }else{
                medianArr[point--] = nums2[j--];
            }
        }

        while(i >= 0) {medianArr[point--] = nums1[i--];}
        while(j >= 0) {medianArr[point--] = nums2[j--];}


        int len = medianArr.length;
        if(len%2==1){
            return medianArr[len/2];
        }else{
            return (medianArr[(len/2)-1]+medianArr[len/2])/2.0;
        }

    }
}