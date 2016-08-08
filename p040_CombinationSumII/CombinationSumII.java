package p040_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        comb(ans, new ArrayList<>(), target, candidates, 0);
        return ans;
    }
    
    void comb(List<List<Integer>> ans, List<Integer> pre, int target,
    		int[] candidates, int begin)
    {
    	if(target == 0)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	for(int i = begin; i < candidates.length && candidates[i] <= target; i++)
    	{
    		if(i == begin || candidates[i] != candidates[i-1])
    		{
    			pre.add(candidates[i]);
    			comb(ans, pre, target-candidates[i], candidates, i+1);
    			pre.remove(pre.size()-1);
    		}
    	}
    }
}
