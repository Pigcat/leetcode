package p121_BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
    	
    	int minPrice = Integer.MAX_VALUE;
    	int maxProfit = 0;
    	for(int i = 0; i < prices.length; i++)
    	{
    		if(prices[i] < minPrice)
    			minPrice = prices[i];
    		else if(prices[i] - minPrice > maxProfit)
    			maxProfit = prices[i] - minPrice;
    	}
    	return maxProfit;
    	
    	/*
        int len = prices.length;
        if(len <= 1)
        	return 0;
        int min = prices[0];
        int profit = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        //int profit = Math.max(0, prices[1] - prices[0]);
        for(int i = 2; i < len; i++)
        {
        	min = min < prices[i-1] ? min : prices[i-1];
        	profit = profit > prices[i] - min ? profit : prices[i] - min;
        	//min = Math.min(min, prices[i-1]);
        	//profit = Math.max(profit, prices[i] - min);
        }
        return profit;
        */
    }
}
