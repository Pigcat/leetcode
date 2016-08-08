package p077_Combinations;

import java.util.List;
import java.util.ArrayList;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> ans = new ArrayList<>();
    	if( n < k || k == 0)
    		return ans;
    	comb(ans, new ArrayList<>(), 1, n, k);
    	return ans;
    }
    
    void comb(List<List<Integer>> ans, List<Integer> pre, int left, int right, int k)
    {
    	if(k == 0)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	for(int i = left; i <= right - (k-1); i++)
    	{
    		pre.add(i);
    		comb(ans, pre, i+1, right, k-1);
    		pre.remove(pre.size() - 1);
    	}
    	
    	/*
    	for(int i = left; i <= right - (k - 1); i++)
    	{
    		List<Integer> t = new ArrayList<>(pre);
    		t.add(i);
    		if(k == 1)
    			ans.add(t);
    		else
    			comb(ans, t, i+1, right, k-1);
    	}
    	*/
    }
}
