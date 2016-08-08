package p134_GasStation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int tSum = 0;
    	int tTotal = 0;
    	int tIndex = 0;
    	for(int i = 0; i < gas.length; i++)
    	{
    		tSum += gas[i] - cost[i];
    		tTotal += gas[i] - cost[i];
    		if(tSum < 0)
    		{
    			tIndex = i+1;
    			tSum = 0;
    		}
    	}
    	if(tTotal < 0)
    		return -1;
    	return tIndex;
    	
    	/*
        int[] profit = new int[gas.length];
        int totalProfit = 0;
        for(int i = 0; i < profit.length; i++)
        {
        	profit[i] = gas[i] - cost[i];
        	totalProfit += profit[i];
        }
        if(totalProfit < 0)
        	return -1;
        int index = -1;
        int sum = -1;
        for(int i = 0; i < profit.length; i++)
        {
        	if(profit[i] < 0)
        		continue;
        	else
        	{
        		int tIndex = i;
        		int tSum = profit[i];
        		for(i = i+1; profit[i%profit.length]>=0 && i < tIndex + profit.length; i++)
        			tSum += profit[i%profit.length];
        		if(tSum > sum)
        		{
        			index = tIndex;
        			sum = tSum;
        		}
        		i--;
        	}
        }
        return index;
        */
    }
}
