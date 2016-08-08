package p090_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> ans = new ArrayList<>();
    	genSubsets(ans, new ArrayList<>(), nums, 0);
    	return ans;
    }
    
    void genSubsets(List<List<Integer>> ans, List<Integer> pre, int[] nums, int begin)
    {
    	if(begin == nums.length)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	int n = 1;
    	for(int i = begin+1; i < nums.length && nums[i] == nums[i-1]; i++)
    		n++;
    	
    	genSubsets(ans, pre, nums, begin+n);
    	for(int i = 1; i <= n; i++)
    	{
    		pre.add(nums[begin]);
    		genSubsets(ans, pre, nums, begin+n);
    	}
    	for(int i = 1; i <= n; i++)
    		pre.remove(pre.size()-1);
    }
}
