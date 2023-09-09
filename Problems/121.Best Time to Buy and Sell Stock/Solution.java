class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        // No need to check for null as constraints : 1 <= prices.length <= 105
        if(len <= 1){
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i<len; i ++){
            // Update the minimum
            if (prices[i] < min){
                min = prices[i];
            }
            else{
                if((prices[i] - min) > profit){
                    // Update the profit
                    profit = prices[i] - min;
                }
            }
        }        
        return profit;
    }
}
