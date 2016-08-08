package p047_PermutationsII;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<>();
    	boolean[] states = new boolean[nums.length];
    	Arrays.sort(nums);
    	genPermuteUnique(ans, new ArrayList<>(), nums, states, nums.length);
    	return ans;
    }
    
    void genPermuteUnique(List<List<Integer>> ans, List<Integer> pre, int[] nums, boolean[] states, int k)
    {
    	if(k == 0)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(states[i] == false)
    		{
    			states[i] = true;
    			pre.add(nums[i]);
    			genPermuteUnique(ans, pre, nums, states, k-1);
    			pre.remove(pre.size()-1);
    			states[i] = false;
        		while(i+1 < nums.length && nums[i] == nums[i+1])
        			i++;
    		}
    	}
    }
}
