package p120_Triangle;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	
    	int size = triangle.size();
    	if(size == 0)
    		return 0;
    	int[] results = new int[size];
    	
    	for(int i = 0; i < size; i++)
    		results[i] = triangle.get(size-1).get(i);
    	
    	for(int i = size -2; i >= 0; i--)
    		for(int j = 0; j <= i; j++)
    			results[j] = Math.min(results[j], results[j+1]) + triangle.get(i).get(j);

    	return results[0];
    	
    	/*
    	int size = triangle.size();
    	if(size == 0)
    		return 0;
        int[] results = new int[triangle.size()];
        results[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++)
        {
        	List<Integer> row = triangle.get(i);
        	for(int j = i; j >= 0; j--)
        	{
        		int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE;
        		if( j-1 >= 0 )
        			t1 = results[j-1] + row.get(j);
        		if( j <= i-1 )
        			t2 = results[j] + row.get(j);
        		results[j] = Math.min(t1, t2);
        	}
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++)
        	if(result > results[i])
        		result = results[i];
        return result;
        */
    }
}
