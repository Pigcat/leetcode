package p078_Subsets;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
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
    	genSubsets(ans, pre, nums, begin+1);
    	pre.add(nums[begin]);
    	genSubsets(ans, pre, nums, begin+1);
    	pre.remove(pre.size()-1);
    }
}
