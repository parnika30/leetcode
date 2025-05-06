// class Solution {
//     public int maxProfit(int[] prices) {
//         int min = Integer.MAX_VALUE;
//         int max = 0;
//         int n = prices.length;
//         for (int i = 0;i<n;i++){    
//             min = Math.min(min, prices[i]);
//             max = Math.max(max, (prices[i]-min));
//         }
//         return max;  
        
//     }
// }


// class Solution { 
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int min = Integer.MAX_VALUE;
//         int max = 0; 

//         for(int i =0;i <n ;i ++){
//             if(prices[i]<min){
//                 min = prices[i];
//             }else{
//                 max = Math.max(max, prices[i] - min);
//             }
//         }
//         return max; 
//     }
// }


class Solution { 
     public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int profit = 0; 

        for(int i =0;i <n ;i ++){
            int cost = prices[i] - min; 
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit; 
    }
}

