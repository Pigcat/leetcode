package p216_CombinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> ans = new ArrayList<>();
    	int[] candidates = new int[9];
    	for(int i = 0; i < 9; i++)
    		candidates[i] = i+1;
    	comb(ans, new ArrayList<>(), n, candidates, 0, k);
    	return ans;
    }
    
    void comb(List<List<Integer>> ans, List<Integer> pre, int target, int[] candidates, int begin, int k)
    {
    	if( k == 0 && target == 0)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	for(int i = begin; i < candidates.length && candidates[i] <= target && k > 0; i++)
    	{
    		pre.add(candidates[i]);
    		comb(ans, pre, target-candidates[i], candidates, i+1, k-1);
    		pre.remove(pre.size()-1);
    	}
    }
}
