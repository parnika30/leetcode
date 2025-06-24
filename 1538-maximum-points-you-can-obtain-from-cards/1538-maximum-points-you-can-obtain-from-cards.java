class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int left = 0; int right = 0;
        for(int i=0; i<=k-1; i++){   
            left += cardPoints[i]; 
        }
        maxSum = left;
        int rightInd = cardPoints.length-1;
        for(int i=k-1; i>=0; i--){   
            left -= cardPoints[i]; 
            right += cardPoints[rightInd]; 
            rightInd -= 1;
            maxSum = Math.max(maxSum, left + right);
        }
        return maxSum;
    }
}