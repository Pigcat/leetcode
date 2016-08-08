package p123_BestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		int[] profits = new int[prices.length];
		
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int i = 0; i < profits.length; i++)
		{
			if(prices[i] < minPrice)
				minPrice = prices[i];
			else if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
			profits[i] = maxProfit;
		}
		
		maxProfit = 0;
		int maxPrice = Integer.MIN_VALUE;
		for(int i = prices.length - 1; i >= 1; i--)
		{
			if(prices[i] > maxPrice)
				maxPrice = prices[i];
			else if(maxPrice - prices[i] > maxProfit)
				maxProfit = maxPrice - prices[i];
			profits[i-1] += maxProfit;
		}
		
		maxProfit = 0;
		for(int i = 0; i < profits.length; i++)
		{
			if(profits[i] > maxProfit)
				maxProfit = profits[i];
		}
		return maxProfit;
	}
	
	
	/*
    public int maxProfit(int[] prices) {
        int maxProfit = calMaxProfit(prices, 0, prices.length - 1);
        if(prices.length <= 3)
        	return maxProfit;
        for(int loc = 1; loc <= prices.length - 2; loc++)
        {
        	int tProfit = calMaxProfit(prices,0,loc) + calMaxProfit(prices,loc+1,prices.length - 1);
        	if(tProfit > maxProfit)
        		maxProfit = tProfit;
        }
        return maxProfit;
    }
    
    int calMaxProfit(int[] prices, int begin, int end)
    {
    	int maxProfit = 0;
    	int minPrice = Integer.MAX_VALUE;
    	for(int i = begin; i <= end; i++)
    	{
    		if(prices[i] < minPrice)
    			minPrice = prices[i];
    		else if(prices[i] - minPrice > maxProfit)
    			maxProfit = prices[i] - minPrice;
    	}
    	return maxProfit;
    }
    */
}
