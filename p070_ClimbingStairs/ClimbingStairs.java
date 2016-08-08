package p070_ClimbingStairs;

public class ClimbingStairs {
    public int climbStairs(int n) {
    	
    	int f1 = 1;
    	int f2 = 2;
    	if(n == 1)
    		return f1;
    	if(n == 2)
    		return f2;
    	int fn = 0;
    	for(int i = 3; i <= n; i++)
    	{
    		fn = f1+f2;
    		f1 = f2;
    		f2 = fn;
    	}
    	return fn;
    	
    	/*
    	if(n == 1)
    		return 1;
    	if(n == 2)
    		return 2;
    	int[] ways = new int[n];
    	ways[0] = 1;
    	ways[1] = 2;
    	for(int i = 2; i < n; i++)
    		ways[i] = ways[i-1] + ways[i-2];
    	return ways[n-1];
    	*/
    	
    	/*
    	if(n <= 0)
    		return 0;
    	else if(n == 1 || n == 2)
        	return 1;
        else
        	return climbStairs(n-1)+climbStairs(n-2);
        */
    }
}
