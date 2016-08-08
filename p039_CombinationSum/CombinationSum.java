package p039_CombinationSum;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> ans = new ArrayList<>();
    	comb(ans, new ArrayList<>(), target, candidates, 0);
    	//comb(ans, new ArrayList<>(), 0, candidates, 0, candidates.length-1, target);
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
    		pre.add(candidates[i]);
    		comb(ans, pre, target-candidates[i], candidates, i);
    		pre.remove(pre.size()-1);
    	}
    }
    /*
    void comb(List<List<Integer>> ans, List<Integer> pre, int presum,
    		int[] candidates, int left, int right, int target)
    {
    	if(left > right)
    		return;
    	for(int i = left; i <= right; i++)
    	{
    		pre.add(candidates[i]);
    		if(presum + candidates[i] < target)
    			comb(ans, pre, presum+candidates[i], candidates, i, right, target);
    		else if (presum + candidates[i] == target)
    			ans.add(new ArrayList<>(pre));
    		else
    		{
    			pre.remove(pre.size()-1);
    			break;
    		}
    		pre.remove(pre.size()-1);
    		while(i+1 <= right && candidates[i] == candidates[i+1])
    			i++;
    	}
    }
    */
}
